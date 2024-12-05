package net.weg.gestao_operadora.repository;

import net.weg.gestao_operadora.model.Cliente;
import net.weg.gestao_operadora.model.ServicoAdicional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServicoRepository extends JpaRepository<ServicoAdicional, Integer> {
}
