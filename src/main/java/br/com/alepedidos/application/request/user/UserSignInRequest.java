package br.com.alepedidos.application.request.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserSignInRequest(
        @Email(message = "Tem que ser um email válido.")
        @NotBlank(message = "Campo email é obrigatório.")
        String email,

        @NotBlank(message = "Campo senha é obrigatório.")
        String password) {
}
