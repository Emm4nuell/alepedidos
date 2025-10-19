package br.com.alepedidos.domain.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_scheduling_roduct")
public class SchedulingProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private int quantity;
    private double size;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_product", nullable = false, foreignKey = @ForeignKey(name = "fk_scheduling_product_product"))
    private ProductModel product;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_scheduling", nullable = false, foreignKey = @ForeignKey(name = "fk_scheduling_product_scheduling"))
    private SchedulingModel scheduling;
}
