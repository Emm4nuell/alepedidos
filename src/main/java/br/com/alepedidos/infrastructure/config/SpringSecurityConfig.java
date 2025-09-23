package br.com.alepedidos.infrastructure.config;

import br.com.alepedidos.infrastructure.components.AuthProviderCustom;
import br.com.alepedidos.infrastructure.components.SpringSecurityFilterCustom;
import br.com.alepedidos.infrastructure.components.UserDetailService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SpringSecurityConfig {

    private final SpringSecurityFilterCustom filterCustom;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http,
            AuthProviderCustom authProviderCustom) throws Exception {
        return http.csrf(csfr -> csfr.disable())
                .authorizeHttpRequests(authorize -> authorize.requestMatchers("/api/ale/signin")
                        .permitAll()
                        .anyRequest()
                        .authenticated())
                .addFilterBefore(filterCustom,
                        UsernamePasswordAuthenticationFilter.class)
                .authenticationProvider(authProviderCustom)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationProvider authenticationProvider) {
        return new ProviderManager(authenticationProvider);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
}
