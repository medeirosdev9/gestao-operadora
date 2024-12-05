package net.weg.gestao_operadora.repository;

import net.weg.gestao_operadora.model.PlanoServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanoServicoRepository extends JpaRepository<PlanoServico, Integer> {

    List<PlanoServico> findAllByPlano_Id(Integer planoId);

    List<PlanoServico> findAllByServico_Id(Integer servicoId);
}
