package br.com.alepedidos.application.request.user;

import jakarta.validation.constraints.NotBlank;

public record RoleRequest(
        @NotBlank(message = "Campo role é obrigatório.")
        String role) {
}
