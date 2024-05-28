package org.example.pdvbackend.Repository;

import org.example.pdvbackend.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByAtivoTrue();
    List<Cliente> findByAtivoFalse();
}
