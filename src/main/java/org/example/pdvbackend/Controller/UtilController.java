package org.example.pdvbackend.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.pdvbackend.Dto.ItemVendaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/pdv/util")
@Tag(name = "Util", description = "APIs relacionada a questões útil")
public class UtilController {

    @Operation(summary = "Calcular o valor total de um produto", description = "Calcula o valor total de um produto com base na quantidade e no preço unitário")
    @PostMapping("/calcular")
    public ResponseEntity<Double> calcularValorTotal(@RequestBody @Valid ItemVendaDTO itemVendaDTO){
        double valorTotal = itemVendaDTO.getQuantidade() * itemVendaDTO.getPrecoUnitario();
        return ResponseEntity.ok(valorTotal);
    }

}
