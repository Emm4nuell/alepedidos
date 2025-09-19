package br.com.alepedidos.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "tb_salgado")
@Data
public class SalgadoEntity {
    private UUID id;
    private String sabor;
    private Integer quantidade;
    private BigDecimal preco;
}
