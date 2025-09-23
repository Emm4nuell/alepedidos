package br.com.alepedidos.infrastructure.components;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AuthProviderCustom implements AuthenticationProvider {

    private final UserDetailService userDetailService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        UserDetails user = userDetailService.loadUserByUsername(authentication.getName());

        if (!passwordEncoder.matches((CharSequence) authentication.getCredentials(),
                user.getPassword())) {
            throw new BadCredentialsException("Usuário ou senha inválido.");
        }
        var authToken = new UsernamePasswordAuthenticationToken(user.getUsername(),
                null,
                user.getAuthorities());
        SecurityContextHolder.getContext()
                .setAuthentication(authToken);
        return authToken;

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
