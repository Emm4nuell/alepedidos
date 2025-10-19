package br.com.alepedidos.application.request.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductRequest(
        @NotBlank(message = "Campo categoria é obrigatório.") String category,
        @NotBlank(message = "Campo nome do produto é obrigatório.") String name,
        String description,
        @NotBlank(message = "Campo sabor é obrigatório.") String flavor,
        String size,
        @NotNull(message = "Preço é obrigatório.") @Positive BigDecimal price,
        String status
//        byte[] photo
) {}

