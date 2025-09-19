package br.com.alepedidos.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "tb_docinho")
@Data
public class DocinhoEntity {
    private UUID id;
    private Integer quantidade;
    private String sabor;
    private BigDecimal preco;
}
