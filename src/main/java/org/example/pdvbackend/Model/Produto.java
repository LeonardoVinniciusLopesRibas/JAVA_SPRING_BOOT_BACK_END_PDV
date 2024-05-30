package org.example.pdvbackend.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "DESCRIÇÃO é obrigatória")
    @NotBlank(message = "DESCRIÇÃO não pode estar em branco")
    @Size(min = 3, max = 100, message = "DESCRIÇÃO deve ter entre 3 e 100 caracteres")
    @Column(name = "descricao", length = 100)
    private String descricao;

    @NotNull(message = "VALOR UNITÁRIO é obrigatório")
    @DecimalMin(value = "0.0", message = "VALOR UNITÁRIO deve ser no mínimo 0.0")
    @Column(name = "valor_unitario")
    private double valor_unitario;

    @Column(name = "categoria", length = 100)
    @NotBlank(message = "CATEGORIA não pode estar em branco")
    @NotNull(message = "CATEGORIA é obrigatória")
    private String categoria;





}
