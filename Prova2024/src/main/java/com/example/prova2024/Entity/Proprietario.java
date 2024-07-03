package com.example.prova2024.Entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Proprietario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank
    @Size(min = 3, message = "O nome precisa ter no mínimo três caracteres")
    private String nome;
    private String cpf;

    @Email
    private String email;
    private String telefone;
    private String endereco;

    @Past
    private LocalDate dataNascimento;
    private LocalDate dataCadastro;

    @OneToMany(mappedBy = "proprietario")
    private List<Carro> listaCarros;
}