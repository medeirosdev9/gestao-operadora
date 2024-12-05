package net.weg.gestao_operadora.service;

import net.weg.gestao_operadora.controller.dto.PlanoServicoRequestDTO;
import net.weg.gestao_operadora.model.Plano;
import net.weg.gestao_operadora.model.PlanoServico;
import net.weg.gestao_operadora.repository.PlanoServicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanoServicoService {
    private PlanoServicoRepository repository;

    public PlanoServico cadastro(PlanoServicoRequestDTO dto) {
        PlanoServico planoServico = dto.conversao();
        return repository.save(planoServico);
    }

    public PlanoServico edicao(Integer id, PlanoServicoRequestDTO dto) {
        PlanoServico planoServico = dto.conversao();
        planoServico.setId(id);
        return repository.save(planoServico);
    }

    public void remover(Integer id) {
        repository.deleteById(id);
    }

    public List<PlanoServico> buscarPorPlano(Integer planoId) {
        return repository.findAllByPlano_Id(planoId);
    }

    public List<PlanoServico> buscarPorServico(Integer servicoId) {
        return repository.findAllByServico_Id(servicoId);
    }
}
