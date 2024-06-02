package org.example.pdvbackend.Service;

import org.example.pdvbackend.Model.Produto;
import org.example.pdvbackend.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> getTudo() {
        Sort sort = Sort.by(Sort.Direction.DESC, "descricao");
        return produtoRepository.findAll(sort);

    }

    public Produto getById(Long id) {
        Optional<Produto> optionalProduto = produtoRepository.findById(id);
        return optionalProduto.orElse(null);
    }

    public Produto post(Produto produto) {
        produtoRepository.save(produto);
        return produto;
    }

    public Produto put(Produto produto) {
        return produtoRepository.save(produto);
    }

}
