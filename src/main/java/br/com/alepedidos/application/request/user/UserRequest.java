package br.com.alepedidos.application.request.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.util.List;

public record UserRequest(@NotBlank(message = "Campo nome é obrigatório.") String name,
        String phone,
        @Email(message = "Tem que ser um email válido.") String email,
        @Size(min = 3, message = "Tem que ter no mínimo 3 caracteres") @NotBlank(message = "Campo senha é obrigatório.") String password,
        @CPF(message = "Tem que ser um cpf válido.") String cpf,
        @Validated List<RoleRequest> roles,
        LocalDate birthDate) {
}
