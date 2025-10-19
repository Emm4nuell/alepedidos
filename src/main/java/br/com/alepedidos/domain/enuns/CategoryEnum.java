package br.com.alepedidos.domain.enuns;

import lombok.Getter;

@Getter
public enum CategoryEnum {

    BOLO(1 , "BOLO"),
    SALGADO(2, "SALGADO"),
    DOCINHO(3, "DOCINHO");

    private final Integer id;
    private final String category;


    CategoryEnum(Integer id,
            String category) {
        this.id = id;
        this.category = category;
    }
}
