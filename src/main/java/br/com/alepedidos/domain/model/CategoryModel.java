package br.com.alepedidos.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_category")
@Data
public class CategoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "category")
    private String category;
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<ProductModel> products;
}
