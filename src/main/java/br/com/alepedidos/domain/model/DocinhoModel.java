package br.com.alepedidos.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "tb_docinho")
@Data
public class DocinhoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "quantidade")
    private Integer quantidade;
    @Column(name = "sabor")
    private String sabor;
    @Column(name = "preco")
    private BigDecimal preco;
    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private PedidoModel pedido;
}
