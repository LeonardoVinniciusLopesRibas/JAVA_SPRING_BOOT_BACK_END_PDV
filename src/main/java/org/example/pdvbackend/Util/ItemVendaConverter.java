package org.example.pdvbackend.Util;

import org.example.pdvbackend.Dto.ItemVendaDTORequestBanco;
import org.example.pdvbackend.Model.ItemVenda;
import org.example.pdvbackend.Service.ProdutoService;
import org.example.pdvbackend.Service.VendaService;

public class ItemVendaConverter {

    public static ItemVenda toEntity(ItemVendaDTORequestBanco dto, ProdutoService produtoService, VendaService vendaService) {
        ItemVenda itemVenda = new ItemVenda();
        itemVenda.setId(dto.getId());
        itemVenda.setQuantidade(dto.getQuantidade());
        itemVenda.setPreco_unitario(dto.getPreco_unitario());
        itemVenda.setPreco_total(dto.getPreco_total());

        if (dto.getIdProduto() != null) {
            itemVenda.setProduto(produtoService.getById(dto.getIdProduto()));
        }

        if (dto.getIdVenda() != null) {
            itemVenda.setVenda(vendaService.getById(dto.getIdVenda()));
        }

        return itemVenda;
    }

}
