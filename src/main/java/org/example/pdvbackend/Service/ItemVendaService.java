package org.example.pdvbackend.Service;

import org.example.pdvbackend.Model.ItemVenda;
import org.example.pdvbackend.Repository.ItemVendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemVendaService {

    @Autowired
    private ItemVendaRepository itemVendaRepository;

    public List<ItemVenda> getAll(){
        return itemVendaRepository.findAll();
    }

    public ItemVenda getById(Long id){
        Optional<ItemVenda> optionalItemVenda = itemVendaRepository.findById(id);
        return optionalItemVenda.orElse(null);
    }

    public ItemVenda post(ItemVenda itemVenda){
        return itemVendaRepository.save(itemVenda);
    }

    public ItemVenda put(ItemVenda itemVenda){
        return itemVendaRepository.save(itemVenda);
    }
}
