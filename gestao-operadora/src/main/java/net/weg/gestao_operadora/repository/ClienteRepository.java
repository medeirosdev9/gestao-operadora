package net.weg.gestao_operadora.repository;

import net.weg.gestao_operadora.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    List<Cliente> findByPlanoId(Integer planoId);
}
