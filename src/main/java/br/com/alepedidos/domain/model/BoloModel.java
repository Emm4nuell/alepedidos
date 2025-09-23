package br.com.alepedidos.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;
@Entity
@Table(name = "tb_bolo")
@Data
public class BoloModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "topper")
    private String topper;
    @Column(name = "tamanho")
    private String tamanho;
    @Column(name = "preco")
    private BigDecimal preco;
    @Column(name = "modelo")
    private String modelo;
    @Column(name = "sabor")
    private String sabor;
    @Column(name = "image_url")
    private String imagemUrl;
    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private PedidoModel pedido;
}
