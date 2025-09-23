package br.com.alepedidos.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "tb_role")
@Data
public class RoleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String role;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserModel user;
}
