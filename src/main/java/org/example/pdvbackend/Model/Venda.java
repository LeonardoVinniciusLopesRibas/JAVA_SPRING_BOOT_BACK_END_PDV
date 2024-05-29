package org.example.pdvbackend.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "venda")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "CLIENTE é obrigatório")
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @NotBlank(message = "Observação não pode conter caracteres especiais")
    private String observacao;
    
    @NotNull(message = "DATA DE VENDA é obrigatório")
    @Column(name = "data_venda")
    private LocalDate data_venda;

    @NotNull(message = "TOTAL é obrigatório")
    @DecimalMin(value = "0.0", message = "TOTAL deve ser no mínimo 0.0")
    @Column(name = "total")
    private double total;

    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemVenda> itens;

}
