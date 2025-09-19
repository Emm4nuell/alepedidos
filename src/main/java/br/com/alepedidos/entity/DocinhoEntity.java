package br.com.alepedidos.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "tb_docinho")
@Data
public class DocinhoEntity {
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
    private PedidoEntity pedido;
}
