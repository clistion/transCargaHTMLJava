package br.com.transcarga.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")

public class User {
    @Id
    private String username;
    
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    //esconder o password apenas nas respostas, mas ainda permitir que ele seja lido nas requisições (ex: POST de login ou cadastro).
    private String password;
    
    private String role;

    // Getters e Setters substituídos por @Data do Lombok

}
