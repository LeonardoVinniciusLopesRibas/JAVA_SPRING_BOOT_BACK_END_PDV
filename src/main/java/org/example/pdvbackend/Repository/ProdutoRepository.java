package org.example.pdvbackend.Repository;

import org.example.pdvbackend.Model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByAtivoTrue();

    List<Produto> findByAtivoFalse();

    Produto findByCodigoInterno(String codigointerno);
}
