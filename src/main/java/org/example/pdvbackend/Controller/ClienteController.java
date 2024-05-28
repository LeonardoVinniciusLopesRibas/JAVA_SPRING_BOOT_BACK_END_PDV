package org.example.pdvbackend.Controller;

import org.example.pdvbackend.Model.Cliente;
import org.example.pdvbackend.Service.ClienteService;
import org.example.pdvbackend.Service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/pdv/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/get/ativos")
    public ResponseEntity<List<Cliente>> getByAtivoTrue(){
        return ResponseEntity.ok(clienteService.getByAtivoTrue());
    }

    @GetMapping("/get/desativos")
    public ResponseEntity<List<Cliente>> getByAtivoFalse(){
        return ResponseEntity.ok(clienteService.getByAtivoFalse());
    }

    @GetMapping("/get/tudo")
    public ResponseEntity<List<Cliente>> getTudo(){
        return ResponseEntity.ok(clienteService.getTudo());
    }

}
