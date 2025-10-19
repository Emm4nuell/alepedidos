package br.com.alepedidos.application.controller;

import br.com.alepedidos.application.request.user.UserRequest;
import br.com.alepedidos.application.request.user.UserSignInRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface IUserController {

    @PostMapping("/signin")
    ResponseEntity<String> signIn(@RequestBody @Valid UserSignInRequest userSignInRequest);

    @PostMapping("/create-user")
//    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<Void> createUser(@RequestBody @Valid UserRequest user);
}

