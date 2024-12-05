package net.weg.gestao_operadora.repository;

import net.weg.gestao_operadora.model.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContratoRepository extends JpaRepository<Contrato, Integer> {
    List<Contrato> findAllByPlano_Id(Integer idPlano);
}
