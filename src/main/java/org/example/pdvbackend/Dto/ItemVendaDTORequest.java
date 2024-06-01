package org.example.pdvbackend.Dto;


import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemVendaDTORequest {

    @NotNull(message = "ID do produto é obrigatório")
    private Long id;

    @NotNull(message = "PRODUTO é obrigatório")
    private String produto;

    @NotNull(message = "QUANTIDADE é obrigatória")
    @DecimalMin(value = "1.0", message = "QUANTIDADE deve ser no mínimo 1.0")
    private double quantidade;

    @NotNull(message = "PREÇO UNITÁRIO é obrigatório")
    @DecimalMin(value = "0.0", message = "PREÇO UNITÁRIO deve ser no mínimo 0.0")
    private double precoUnitario;

}
