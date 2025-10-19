package br.com.alepedidos.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_product")
@Data
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "flavor")
    private String flavor;
    @Column(name = "size")
    private String size;
    @Column(name = "status")
    private boolean status;
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<SchedulingProductModel> schedulingProducts;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_category", nullable = false, foreignKey = @ForeignKey(name = "fk_product_category"))
    private CategoryModel category;

}
