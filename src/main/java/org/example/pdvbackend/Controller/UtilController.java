package org.example.pdvbackend.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.pdvbackend.Dto.ItemVendaDTORequest;
import org.example.pdvbackend.Dto.VendaDTORequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/pdv/util")
@Tag(name = "Util", description = "APIs relacionada a questões útil")
public class UtilController {

    @Operation(summary = "Calcular o valor total de um produto", description = "Calcula o valor total de um produto com base na quantidade e no preço unitário")
    @PostMapping("/calcular")
    public ResponseEntity<Double> calcularValorTotal(@RequestBody @Valid ItemVendaDTORequest itemVendaDTO){
        double valorTotal = itemVendaDTO.getQuantidade() * itemVendaDTO.getPrecoUnitario();
        return ResponseEntity.ok(valorTotal);
    }

    @Operation(summary = "Calcular valor total da venda", description = "Calcula o valor total da venda")
    @PostMapping("/calcular/tudo")
    public ResponseEntity<Double> calcularValorTotalTodo(@RequestBody @Valid VendaDTORequest vendaDTORequest){
        double soma = vendaDTORequest.getValorTotalVenda().stream().mapToDouble(Double::doubleValue).sum();
        return ResponseEntity.ok(soma);
    }

}
