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

    @NotNull(message = "NOME FANTASIA é obrigatório")
    @NotEmpty(message = "NOME FANTASIA não deve ser vazio")
    @NotBlank(message = "NOME FANTASIA não deve ser em branco")
    @Size(min = 2, max = 100, message = "NOME FANTASIA deve ter entre 2 e 100 caracteres")
    @Column(name = "nome_fantasia", length = 100)
    private String nome_fantasia;

    @Size(max = 100, message = "RAZÃO SOCIAL deve ter no máximo 100 caracteres")
    @Column(name = "razao_social", length = 100)
    private String razao_social;

    @CPF(message = "CPF inválido")
    @Column(name = "cpf", length = 11, unique = true)
    private String cpf;

    @CNPJ(message = "CNPJ inválido")
    @Column(name = "cnpj", length = 14, unique = true)
    private String cnpj;

    @NotNull(message = "CEP é obrigatório")
    @NotBlank(message = "CEP não deve ser em branco")
    @NotEmpty(message = "CEP não deve ser vazio")
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "CEP deve estar no formato 99999-999")
    @Column(name = "cep", length = 9)
    private String cep;

    @NotNull(message = "LOGRADOURO é obrigatório")
    @NotBlank(message = "LOGRADOURO não deve ser em branco")
    @NotEmpty(message = "LOGRADOURO não deve ser vazio")
    @Size(min = 1, max = 100, message = "LOGRADOURO deve ter entre 1 e 100 caracteres")
    @Column(name = "logradouro", length = 100)
    private String logradouro;

    @Size(max = 100, message = "COMPLEMENTO deve ter no máximo 100 caracteres")
    @Column(name = "complemento", length = 100)
    private String complemento;

    @NotNull(message = "BAIRRO é obrigatório")
    @NotBlank(message = "BAIRRO não deve ser em branco")
    @NotEmpty(message = "BAIRRO não deve ser vazio")
    @Size(max = 50, message = "BAIRRO deve ter no máximo 50 caracteres")
    @Column(name = "bairro", length = 50)
    private String bairro;

    @NotNull(message = "LOCALIDADE é obrigatório")
    @NotBlank(message = "LOCALIDADE não deve ser em branco")
    @NotEmpty(message = "LOCALIDADE não deve ser vazio")
    @Size(max = 50, message = "LOCALIDADE deve ter no máximo 50 caracteres")
    @Column(name = "localidade", length = 50)
    private String localidade;

    @NotNull(message = "UF é obrigatório")
    @NotBlank(message = "UF não deve ser em branco")
    @NotEmpty(message = "UF não deve ser vazio")
    @Pattern(regexp = "[A-Z]{2}", message = "UF deve conter 2 letras maiúsculas")
    @Column(name = "uf", length = 2)
    private String uf;

    @NotNull(message = "IBGE é obrigatório")
    @NotBlank(message = "IBGE não deve ser em branco")
    @NotEmpty(message = "IBGE não deve ser vazio")
    @Pattern(regexp = "\\d{7}", message = "IBGE deve conter 7 dígitos")
    @Column(name = "ibge", length = 7)
    private String ibge;

    @Size(max = 10, message = "GIA deve ter no máximo 10 caracteres")
    @Column(name = "gia", length = 10)
    private String gia;

    @NotNull(message = "DDD é obrigatório")
    @NotBlank(message = "DDD não deve ser em branco")
    @NotEmpty(message = "DDD não deve ser vazio")
    @Pattern(regexp = "\\d{2}", message = "DDD deve conter 2 dígitos")
    @Column(name = "ddd", length = 2)
    private String ddd;

    @NotNull(message = "SIAFI é obrigatório")
    @NotBlank(message = "SIAFI não deve ser em branco")
    @NotEmpty(message = "SIAFI não deve ser vazio")
    @Pattern(regexp = "\\d{4}", message = "SIAFI deve conter 4 dígitos")
    @Column(name = "siafi", length = 4)
    private String siafi;

    @NotNull(message = "ATIVO é obrigatório")
    @Column(name = "ativo")
    private boolean ativo;

    @NotNull(message = "DATA DE CADASTRO é obrigatório")
    @Column(name = "data_cadastro")
    private LocalDate data_cadastro;

    @NotNull(message = "DATA DE ALTERAÇÃO é obrigatório")
    @Column(name = "data_alteracao")
    private LocalDate data_alteracao;

}
