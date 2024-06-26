package org.example.pdvbackend.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "item_venda")
public class ItemVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "venda_id")
    private Venda venda;


    @NotNull(message = "PRODUTO é obrigatório")
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @NotNull(message = "QUANTIDADE é obrigatória")
    @DecimalMin(value = "1.0", message = "QUANTIDADE deve ser no mínimo 1.0")
    @Column(name = "quantidade")
    private double quantidade;

    @NotNull(message = "PREÇO UNITÁRIO é obrigatório")
    @DecimalMin(value = "0.0", message = "PREÇO UNITÁRIO deve ser no mínimo 0.0")
    @Column(name = "preco_unitario")
    private double preco_unitario;

    @NotNull(message = "PREÇO TOTAL é obrigatório")
    @DecimalMin(value = "0.0", message = "PREÇO TOTAL deve ser no mínimo 0.0")
    @Column(name = "preco_total")
    private double preco_total;


}
