package org.example.pdvbackend.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.pdvbackend.Enum.StatusEnum;

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

    @NotNull(message = "DATA DE VENDA é obrigatório")
    @Column(name = "data_venda")
    private LocalDate data_venda;

    @NotNull(message = "TOTAL é obrigatório")
    @DecimalMin(value = "0.0", message = "TOTAL deve ser no mínimo 0.0")
    @Column(name = "total")
    private double total;

    @NotNull(message = "DESCONTO é obrigatório")
    @DecimalMin(value = "0.0", message = "DESCONTO deve ser no mínimo 0.0")
    @Column(name = "desconto")
    private double desconto;

    @NotNull(message = "STATUS é obrigatório")
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusEnum status;

    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemVenda> itens;

    @NotNull(message = "DATA DE CADASTRO é obrigatório")
    @Column(name = "data_cadastro")
    private LocalDate data_cadastro;

    @NotNull(message = "DATA DE ALTERAÇÃO é obrigatório")
    @Column(name = "data_alteracao")
    private LocalDate data_alteracao;

    @PrePersist
    @PreUpdate
    private void calculateTotal() {
        total = itens.stream().mapToDouble(ItemVenda::getTotal).sum() - desconto;
    }
}
