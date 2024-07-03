package com.example.prova2024.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank
    @Size(min = 3, message = "O nome do modelo precisa ter no mínimo três caracteres!")
    private String modelo;

    @Size(min = 2, message = "O nome da marca precisa ter no mínimo dois caracteres!")
    private String marca;

    @Min(value = 1885, message = "A data de fabricação do carro não pode  ser anteceder 1885!")
    @Max(value = 2024, message = "A data de fabricação do carro não pode  estar no futuro!")
    private int ano;

    private String cor;

    @Min(value = 1, message = "O valor do carro não pode ser 0 ou negativo!")
    private Double preco;

    @Min(value = 0, message = "A quilometragem do carro não pode ser negativa!")
    private Double quilometragem;

    private LocalDate dataCadastro;

    @ManyToOne
    private Proprietario proprietario;
}
