package br.com.alepedidos.domain.enuns;

import lombok.Getter;

@Getter
public enum RoleEnum {
    ADMINISTRADOR(1,
            "ADMINISTRADOR"),
    GERENTE(2,
            "GERENTE"),
    ATENDENTE(3,
            "ATENDENTE"),
    COZINHA(4,
            "COZINHA");

    private final Integer id;
    private final String name;

    RoleEnum(Integer id,
            String name) {
        this.id = id;
        this.name = name;
    }

}
