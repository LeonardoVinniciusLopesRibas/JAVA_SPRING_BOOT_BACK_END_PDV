package org.example.pdvbackend.Service;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.example.pdvbackend.Dto.ItemVendaDTORequestBanco;
import org.example.pdvbackend.Model.ItemVenda;
import org.example.pdvbackend.Repository.ItemVendaRepository;
import org.example.pdvbackend.Util.ItemVendaConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemVendaService {

    @Autowired
    private ItemVendaRepository itemVendaRepository;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private VendaService vendaService;

    public List<ItemVenda> getAll(){
        return itemVendaRepository.findAll();
    }

    public ItemVenda getById(Long id){
        Optional<ItemVenda> optionalItemVenda = itemVendaRepository.findById(id);
        return optionalItemVenda.orElse(null);
    }

    @Transactional
    public ItemVenda post(ItemVendaDTORequestBanco itemVendaDto) {
        ItemVenda itemVenda = ItemVendaConverter.toEntity(itemVendaDto, produtoService, vendaService);
        return itemVendaRepository.save(itemVenda);
    }

    public ItemVenda put(ItemVenda itemVenda){
        return itemVendaRepository.save(itemVenda);
    }
}
