package org.example.pdvbackend.Service;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.example.pdvbackend.Model.Cliente;
import org.example.pdvbackend.Model.Venda;
import org.example.pdvbackend.Repository.ClienteRepository;
import org.example.pdvbackend.Repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private EntityManager entityManager;

    public java.util.List<Venda> getTudo() {
        return vendaRepository.findAll();
    }

    public Venda getById(Long id) {
        Optional<Venda> optionalVenda = vendaRepository.findById(id);
        return optionalVenda.orElse(null);
    }

    @Transactional
    public Venda post(Venda venda){
        vendaRepository.save(venda);
        return venda;
    }

    public Venda put(Venda venda){
        return vendaRepository.save(venda);
    }
}
