package br.com.transcarga.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    
    @JsonIgnore
    //não retornar o password na resposta do get User
    private String password;
    
    private String role;

    // Getters e Setters substituídos por @Data do Lombok

}
