package org.example.pdvbackend.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.pdvbackend.Model.Cliente;
import org.example.pdvbackend.Service.ClienteService;
import org.example.pdvbackend.Service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/pdv/cliente")
@Tag(name = "Cliente", description = "APIs relacionadas a Cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Operation(summary = "Obter todos os clientes", description = "Retorna uma lista de todos os clientes")
    @GetMapping("/get/tudo")
    public ResponseEntity<List<Cliente>> getTudo(){
        return ResponseEntity.ok(clienteService.getTudo());
    }

    @Operation(summary = "Obter cliente por ID", description = "Retorna um cliente específico pelo ID")
    @GetMapping("/get/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable Long id){
        return ResponseEntity.ok(clienteService.getById(id));
    }

    @Operation(summary = "Criar novo cliente", description = "Cria um novo cliente e retorna o cliente criado")
    @PostMapping("/post")
    public ResponseEntity<Cliente> post(@RequestBody @Valid Cliente cliente, UriComponentsBuilder builder){
        clienteService.post(cliente);
        URI uri = builder.path("/pdv/produto/get/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(cliente);
    }

    @Operation(summary = "Atualizar cliente", description = "Atualiza as informações de um cliente existente")
    @PutMapping("/put/{id}")
    public ResponseEntity<Cliente> put(@PathVariable Long id, @RequestBody @Valid Cliente cliente){
        clienteService.put(cliente);
        return ResponseEntity.ok(cliente);
    }

}
