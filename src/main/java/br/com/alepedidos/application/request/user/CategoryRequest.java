package br.com.alepedidos.application.request.user;

import jakarta.validation.constraints.NotBlank;

public record CategoryRequest(@NotBlank(message = "Campo categoria é obrigatório.") String category) {
}
