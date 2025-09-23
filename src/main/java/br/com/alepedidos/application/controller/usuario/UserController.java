package br.com.alepedidos.application.controller.usuario;

import br.com.alepedidos.application.controller.IUserController;
import br.com.alepedidos.application.request.user.UserRequest;
import br.com.alepedidos.application.request.user.UserSignInRequest;
import br.com.alepedidos.domain.service.IUserService;
import br.com.alepedidos.domain.service.JwtTokenService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ale")
@AllArgsConstructor
public class UserController implements IUserController {

    private final IUserService iUserService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenService tokenService;

    @Override
    public ResponseEntity<String> signIn(UserSignInRequest request) {
        Authentication authenticationRequest = UsernamePasswordAuthenticationToken.unauthenticated(request.email(), request.password());
        Authentication authenticationResponse = this.authenticationManager.authenticate(authenticationRequest);
        var token = tokenService.generateToken(authenticationResponse.getName());
        return ResponseEntity.ok().body("Bearer " + token);
    }

    @Override
    public ResponseEntity<Void> createUser(UserRequest request) {
        var user = iUserService.createUser(request);
        return ResponseEntity.ok().build();
    }
}

