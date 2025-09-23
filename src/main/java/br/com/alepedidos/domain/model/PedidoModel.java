package br.com.alepedidos.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_pedido")
@Data
public class PedidoModel extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "codigo")
    private Long codigo;
    @Column(name = "nome")
    private String nome;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "data_pedido")
    private LocalDate dataPedido;
    @Column(name = "realizado_pagamento")
    private boolean realizadoPagamento;
    @Column(name = "email")
    private String email;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "data_retirada")
    private LocalDate dataRetirada;
    @Column(name = "qrcode")
    private String qrcode;
    @Column(name = "desconto")
    private double desconto;
    @Column(name = "preco_total")
    private BigDecimal precoTotal;
    @Column(name = "preco_total_desconto")
    private BigDecimal precoTotalDesconto;
    @OneToMany(mappedBy = "pedido",fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private List<SalgadoModel> salgados;
    @OneToMany(mappedBy = "pedido", fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private List<DocinhoModel> docinho;
    @OneToMany(mappedBy = "pedido", fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private List<BoloModel> bolos;
}
