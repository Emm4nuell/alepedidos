package br.com.alepedidos.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_pedido")
@Data
public class PedidoEntity {
    private UUID id;
    private Long codigo;
    private String nome;
    private String telefone;
    private Date data_pedido;
    private boolean realizado_pagamento;
    private String email;
    private String cpf;
    private Date data_retirada;
    private List<SalgadoEntity> salgados;
    private List<DocinhoEntity> docinho;
    private List<BoloEntity> bolos;
    private String qrcode;
    private double desconto;
    private BigDecimal preco_total;
    private BigDecimal preco_total_desconto;
}
