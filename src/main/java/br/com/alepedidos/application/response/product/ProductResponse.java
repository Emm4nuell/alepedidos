package br.com.alepedidos.application.response.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ProductResponse(
        UUID id,
        String category,
        String name,
        String description,
        String flavor,
        String size,
        String status
//        String photoUrl
) {}
