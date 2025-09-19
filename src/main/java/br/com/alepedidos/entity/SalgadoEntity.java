package br.com.alepedidos.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "tb_salgado")
@Data
public class SalgadoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "sabor")
    private String sabor;
    @Column(name = "quantidade")
    private Integer quantidade;
    @Column(name = "preco")
    private BigDecimal preco;
    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private PedidoEntity pedido;
}
