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

    @NotNull(message = "ESTOQUE ATUAL é obrigatório")
    @DecimalMin(value = "0.0", message = "ESTOQUE ATUAL deve ser no mínimo 0.0")
    @Column(name = "estoque_atual")
    private double estoque_atual;

    @NotNull(message = "ESTOQUE MÍNIMO é obrigatório")
    @DecimalMin(value = "0.0", message = "ESTOQUE MÍNIMO deve ser no mínimo 0.0")
    @Column(name = "estoque_minimo")
    private double estoque_minimo;

    @NotNull(message = "VALOR DE CUSTO é obrigatório")
    @DecimalMin(value = "0.0", message = "VALOR DE CUSTO deve ser no mínimo 0.0")
    @Column(name = "valor_custo")
    private double valor_custo;

    @NotNull(message = "PERCENTUAL DE LUCRO é obrigatório")
    @DecimalMin(value = "0.0", message = "PERCENTUAL DE LUCRO deve ser no mínimo 0.0")
    @Column(name = "percentual_lucro")
    private double percentual_lucro;

    @NotNull(message = "VALOR UNITÁRIO é obrigatório")
    @DecimalMin(value = "0.0", message = "VALOR UNITÁRIO deve ser no mínimo 0.0")
    @Column(name = "valor_unitario")
    private double valor_unitario;

    @NotNull(message = "ATIVO é obrigatório")
    @Column(name = "ativo")
    private boolean ativo;

    @NotNull(message = "CÓDIGO INTERNO é obrigatório")
    @NotBlank(message = "CÓDIGO INTERNO não pode estar em branco")
    @Size(min = 1, max = 100, message = "CÓDIGO INTERNO deve ter entre 1 e 100 caracteres")
    @Column(name = "codigo_interno", length = 100, unique = true)
    private String codigo_interno;

    @NotNull(message = "DATA DE CADASTRO é obrigatório")
    @Column(name = "data_cadastro")
    private LocalDate data_cadastro;

    @NotNull(message = "DATA DE ALTERAÇÃO é obrigatório")
    @Column(name = "data_alteracao")
    private LocalDate data_alteracao;




}
