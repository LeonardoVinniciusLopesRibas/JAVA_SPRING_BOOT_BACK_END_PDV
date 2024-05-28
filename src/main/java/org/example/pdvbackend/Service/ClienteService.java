package org.example.pdvbackend.Service;

import org.example.pdvbackend.Model.Cliente;
import org.example.pdvbackend.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getByAtivoTrue() {
        return clienteRepository.findByAtivoTrue();
    }

    public List<Cliente> getByAtivoFalse() {
        return clienteRepository.findByAtivoFalse();
    }

    public List<Cliente> getTudo() {
        return clienteRepository.findAll();
    }
}
