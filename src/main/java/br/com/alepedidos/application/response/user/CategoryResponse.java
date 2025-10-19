package br.com.alepedidos.application.response.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.UUID;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryResponse {
    private UUID id;
    private String category;
}
