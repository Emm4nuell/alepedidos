package br.com.alepedidos.application.controller;

import br.com.alepedidos.application.request.user.UserRequest;
import br.com.alepedidos.application.request.user.UserSignInRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface IUserController {

    @PostMapping("/signin")
    ResponseEntity<String> signIn(@RequestBody @Valid UserSignInRequest userSignInRequest);

    @PostMapping("/create-user")
    ResponseEntity<Void> createUser(@RequestBody @Valid UserRequest user);
}

