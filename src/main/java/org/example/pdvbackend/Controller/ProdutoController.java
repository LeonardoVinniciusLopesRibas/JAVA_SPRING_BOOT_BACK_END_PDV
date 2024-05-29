package org.example.pdvbackend.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.example.pdvbackend.Model.Produto;
import org.example.pdvbackend.Service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/pdv/produto")
@Tag(name = "Produto", description = "APIs relacionadas a Produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Operation(summary = "Obter todos os produtos", description = "Retorna uma lista de todos os produtos")
    @GetMapping("/get/tudo")
    public ResponseEntity<List<Produto>> getTudo(){
        return ResponseEntity.ok(produtoService.getTudo());
    }

    @Operation(summary = "Obter produto por ID", description = "Retorna um produto específico pelo ID")
    @GetMapping("/get/{id}")
    public ResponseEntity<Produto> getById(@PathVariable Long id){
        return ResponseEntity.ok(produtoService.getById(id));
    }

    @Operation(summary = "Criar novo produto", description = "Cria um novo produto e retorna o produto criado")
    @PostMapping("/post")
    public ResponseEntity<Produto> post(@RequestBody @Valid Produto produto, UriComponentsBuilder builder){
        produtoService.post(produto);
        URI uri = builder.path("/pdv/produto/get/{id}").buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).body(produto);
    }

    @Operation(summary = "Atualizar produto", description = "Atualiza as informações de um produto existente")
    @PutMapping("/put/{id}")
    public ResponseEntity<Produto> put(@PathVariable Long id, @RequestBody @Valid Produto produto){
        produtoService.put(produto);
        return ResponseEntity.ok(produto);
    }

}
