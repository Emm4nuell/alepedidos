package br.com.alepedidos.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;
@Entity
@Table(name = "tb_bolo")
@Data
public class BoloEntity {
    private UUID id;
    private String topper;
    private String tamanho;
    private BigDecimal preco;
    private String modelo;
    private String sabor;
    private String imagem;
}
