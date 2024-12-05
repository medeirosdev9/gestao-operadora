package net.weg.gestao_operadora.service;

import lombok.AllArgsConstructor;
import net.weg.gestao_operadora.model.Cliente;
import net.weg.gestao_operadora.model.Plano;
import net.weg.gestao_operadora.model.ServicoAdicional;
import net.weg.gestao_operadora.repository.ServicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ServicoService {
    private ServicoRepository repository;

    public ServicoAdicional cadastro(ServicoAdicional servicoAdicional) {
        return repository.save(servicoAdicional);
    }


    public ServicoAdicional editar(Integer id, ServicoAdicional servicoAdicional) {
        servicoAdicional.setId(id);
        return repository.save(servicoAdicional);
    }

    public ServicoAdicional alterarDescricao(Integer id, String descricao) {
        ServicoAdicional servicoAdicional = buscar(id);
        servicoAdicional.setDescricao(descricao);
        return repository.save(servicoAdicional);
    }

    public ServicoAdicional buscar(Integer id) {
        Optional<ServicoAdicional> servicoAdicional = repository.findById(id);
        return servicoAdicional.orElseThrow(() -> new NoSuchElementException("Serviço não encontrado"));
    }

    public List<ServicoAdicional> buscar() {
        return repository.findAll();
    }

    public void remover(Integer id) {
        repository.deleteById(id);
    }
}
