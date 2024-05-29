package org.example.pdvbackend.Service;

import org.example.pdvbackend.Model.Cliente;
import org.example.pdvbackend.Repository.ClienteRepository;
import org.example.pdvbackend.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getTudo() {
        return clienteRepository.findAll();
    }

    public Cliente getById(Long id) {
        Optional<Cliente> optionalCliente = clienteRepository.findById(id);
        return optionalCliente.orElse(null);
    }

    public Cliente post(Cliente cliente){
        clienteRepository.save(cliente);
        return cliente;
    }

    public Cliente put(Cliente cliente){
        return clienteRepository.save(cliente);
    }
}
