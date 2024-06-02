package org.example.pdvbackend.Dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemVendaDTORequestBanco {

    private Long id;
    private Long idVenda;

    @NotNull(message = "PRODUTO é obrigatório")
    private Long idProduto;

    @NotNull(message = "QUANTIDADE é obrigatória")
    @DecimalMin(value = "1.0", message = "QUANTIDADE deve ser no mínimo 1.0")
    private double quantidade;

    @NotNull(message = "PREÇO UNITÁRIO é obrigatório")
    @DecimalMin(value = "0.0", message = "PREÇO UNITÁRIO deve ser no mínimo 0.0")
    private double preco_unitario;

    @NotNull(message = "PREÇO TOTAL é obrigatório")
    @DecimalMin(value = "0.0", message = "PREÇO TOTAL deve ser no mínimo 0.0")
    private double preco_total;

}
