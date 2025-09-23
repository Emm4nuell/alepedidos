package br.com.alepedidos.application.response.user;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class UserResponse {
    private UUID id;
    private String name;
    private String phone;
    private String email;
    private String password;
    private String cpf;
    private LocalDate birthDate;
}
