package br.com.alepedidos.domain.model;

import br.com.alepedidos.domain.enuns.RoleEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tb_user")
@Data
public class UserModel extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "cpf", unique = true)
    private String cpf;
    @Column(name = "birth_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    @Column(name = "status")
    private boolean status;
    @Column(name = "function")
    private String function;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "tb_role", joinColumns = @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_user_role", foreignKeyDefinition = "CONSTRAINT fk_user_role FOREIGN KEY (user_id) REFERENCES tb_user(id) ON DELETE CASCADE")))
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Set<RoleEnum> roles;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SchedulingModel> schedulings;
}
