package org.example.pdvbackend.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "NOME é obrigatório")
    @NotEmpty(message = "NOME não deve ser vazio")
    @NotBlank(message = "NOME não deve ser em branco")
    @Size(min = 2, max = 100, message = "NOME deve ter entre 2 e 100 caracteres")
    @Column(name = "nome", length = 100)
    private String nome;

    @NotNull(message = "EMAIL é obrigatório")
    @NotEmpty(message = "EMAIL não deve ser vazio")
    @Email(message = "EMAIL deve ser válido")
    @Column(name = "email", length = 100, unique = true)
    private String email;

    @Pattern(regexp = "\\(\\d{2}\\) \\d{4,5}-\\d{4}", message = "TELEFONE deve seguir o padrão (xx) xxxx-xxxx ou (xx) xxxxx-xxxx")
    @NotNull(message = "TELEFONE é obrigatório")
    @NotEmpty(message = "TELEFONE não deve ser vazio")
    @NotBlank(message = "TELEFONE não pode ser em branco")
    @Column(name = "telefone", length = 15)
    private String telefone;


}
