package org.example.pdvbackend.Controller;

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
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/get/ativos")
    public ResponseEntity<List<Produto>> getByAtivoTrue(){
        return ResponseEntity.ok(produtoService.getByAtivoTrue());
    }

    @GetMapping("/get/desativos")
    public ResponseEntity<List<Produto>> getByAtivoFalse(){
        return ResponseEntity.ok(produtoService.getByAtivoFalse());
    }

    @GetMapping("/get/tudo")
    public ResponseEntity<List<Produto>> getTudo(){
        return ResponseEntity.ok(produtoService.getTudo());
    }

    @GetMapping("/get/{codigointerno}")
    public ResponseEntity<Produto> getByCodigoInterno(@PathVariable String codigointerno){
        return ResponseEntity.ok(produtoService.getByCodigoInterno(codigointerno));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Produto> getById(@PathVariable Long id){
        return ResponseEntity.ok(produtoService.getById(id));
    }

    @PostMapping("/post")
    public ResponseEntity<Produto> post(@RequestBody @Valid Produto produto, UriComponentsBuilder builder){
        produtoService.post(produto);
        URI uri = builder.path("/pdv/produto/get/{id}").buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).body(produto);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Produto> put(@PathVariable Long id, @RequestBody @Valid Produto produto){
        produtoService.put(produto);
        return ResponseEntity.ok(produto);
    }

    @PutMapping("put/ativo/{id}/true")
    public ResponseEntity<Produto> putAtivoTrue(@PathVariable Long id){
        Produto produto = produtoService.putAtivo(id, true);
        return ResponseEntity.ok(produto);
    }

    @PutMapping("put/ativo/{id}/false")
    public ResponseEntity<Produto> putAtivoFalse(@PathVariable Long id){
        Produto produto = produtoService.putAtivo(id, false);
        return ResponseEntity.ok(produto);
    }

}
