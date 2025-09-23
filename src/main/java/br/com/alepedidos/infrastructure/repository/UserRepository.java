package br.com.alepedidos.infrastructure.repository;

import br.com.alepedidos.domain.model.UserModel;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {
    @Query(value = "SELECT CASE WHEN COUNT(*) > 0 THEN true ELSE false END FROM tb_user u WHERE u.email = :email OR u.cpf = :cpf", nativeQuery = true)
    public boolean existsByCpfOrEmail(@Param("email") String email, @Param("cpf") String cpf);

    @Query(value = "SELECT * FROM tb_user u WHERE u.email = :email LIMIT 1", nativeQuery = true)
    public Optional<UserModel> findByEmail(@Param("email") String email);
}
