package org.example.pdvbackend.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.pdvbackend.Model.ItemVenda;
import org.example.pdvbackend.Service.ItemVendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/pdv/itemvenda")
@Tag(name = "ItemVenda", description = "APIs relacionadas a ItemVenda")
public class ItemVendaController {

    @Autowired
    private ItemVendaService itemVendaService;

    @Operation(summary = "Obter todos os itens de venda", description = "Retorna uma lista de todos os itens de venda")
    @GetMapping("/get/tudo")
    public ResponseEntity<List<ItemVenda>> getTudo(){
        return ResponseEntity.ok(itemVendaService.getAll());
    }

    @Operation(summary = "Obter item de venda por ID", description = "Retorna um item de venda específico pelo ID")
    @GetMapping("/get/{id}")
    public ResponseEntity<ItemVenda> getById(@PathVariable Long id){
        return ResponseEntity.ok(itemVendaService.getById(id));
    }

    @Operation(summary = "Criar novo item de venda", description = "Cria um novo item de venda e retorna o item criado")
    @PostMapping("/post")
    public ResponseEntity<ItemVenda> post(@RequestBody @Valid ItemVenda itemVenda, UriComponentsBuilder builder){
        itemVendaService.post(itemVenda);
        URI uri = builder.path("/pdv/itemvenda/get/{id}").buildAndExpand(itemVenda.getId()).toUri();
        return ResponseEntity.created(uri).body(itemVenda);
    }

    @Operation(summary = "Atualizar item de venda", description = "Atualiza as informações de um item de venda existente")
    @PutMapping("put/{id}")
    public ResponseEntity<ItemVenda> put(@PathVariable Long id, @RequestBody @Valid ItemVenda itemVenda){
        itemVendaService.put(itemVenda);
        return ResponseEntity.ok(itemVenda);
    }
}
