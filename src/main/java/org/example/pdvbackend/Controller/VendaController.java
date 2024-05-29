package org.example.pdvbackend.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.example.pdvbackend.Model.Venda;
import org.example.pdvbackend.Service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/pdv/venda")
@Tag(name = "Venda", description = "APIs relacionadas a Venda")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @Operation(summary = "Obter todas as vendas", description = "Retorna uma lista de todas as vendas")
    @GetMapping("/get/tudo")
    public ResponseEntity<List<Venda>> getTudo(){
        return ResponseEntity.ok(vendaService.getTudo());
    }

    @Operation(summary = "Obter venda por ID", description = "Retorna uma venda específica pelo ID")
    @GetMapping("/get/{id}")
    public ResponseEntity<Venda> getById(@PathVariable Long id){
        return ResponseEntity.ok(vendaService.getById(id));
    }

    @Operation(summary = "Criar nova venda", description = "Cria uma nova venda e retorna a venda criada")
    @PostMapping("/post")
    public ResponseEntity<Venda> post(@RequestBody @Valid Venda venda, UriComponentsBuilder builder){
        vendaService.post(venda);
        URI uri = builder.path("/pdv/itemvenda/get/{id}").buildAndExpand(venda.getId()).toUri();
        return ResponseEntity.created(uri).body(venda);
    }

    @Operation(summary = "Atualizar venda", description = "Atualiza as informações de uma venda existente")
    @PutMapping("put/{id}")
    public ResponseEntity<Venda> put(@PathVariable Long id, @RequestBody @Valid Venda venda){
        vendaService.put(venda);
        return ResponseEntity.ok(venda);
    }




}
