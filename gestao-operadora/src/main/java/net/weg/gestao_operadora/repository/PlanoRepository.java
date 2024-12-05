package net.weg.gestao_operadora.repository;

import net.weg.gestao_operadora.model.Plano;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlanoRepository extends JpaRepository<Plano, Integer> {
    Optional<Plano> findByNome(String nome);
}
