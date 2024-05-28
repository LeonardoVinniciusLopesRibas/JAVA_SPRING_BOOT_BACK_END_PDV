package org.example.pdvbackend.Service;

import org.example.pdvbackend.Model.Produto;
import org.example.pdvbackend.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> getByAtivoTrue(){
        return produtoRepository.findByAtivoTrue();
    }
    public List<Produto> getByAtivoFalse(){
        return produtoRepository.findByAtivoFalse();
    }

    public List<Produto> getTudo() {
        return produtoRepository.findAll();
    }

    public Produto getByCodigoInterno(String codigointerno) {
        return produtoRepository.findByCodigoInterno(codigointerno);
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

    public Produto putAtivo(Long id, boolean b) {
        Optional<Produto> optionalProduto = produtoRepository.findById(id);
        Produto produto = optionalProduto.get();
        produto.setAtivo(b);
        return produtoRepository.save(produto);
    }
}
