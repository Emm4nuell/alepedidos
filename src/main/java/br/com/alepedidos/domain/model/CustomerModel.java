package br.com.alepedidos.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_customer")
@Data
public class CustomerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "phone")
    private String phone;
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<SchedulingModel> schedulings;
}
