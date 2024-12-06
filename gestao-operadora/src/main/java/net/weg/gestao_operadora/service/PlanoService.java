package net.weg.gestao_operadora.service;

import lombok.AllArgsConstructor;
import net.weg.gestao_operadora.model.Plano;
import net.weg.gestao_operadora.repository.ClienteRepository;
import net.weg.gestao_operadora.repository.PlanoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PlanoService {
    private PlanoRepository repository;

    public Plano cadastro(Plano plano) {
        return repository.save(plano);
    }

    public Plano editar(Integer id, Plano plano) {
        plano.setId(id);
        return repository.save(plano);
    }

    public Plano alterarValor(Integer id, double valor) {
        Plano plano = buscar(id);
        plano.setValor(valor);
        return repository.save(plano);
    }

    public Plano buscar(Integer id) {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException("Plano não encontrado"));
    }

    public Plano buscar(String nome) {
        return repository.findByNome(nome).orElseThrow(() -> new NoSuchElementException("Plano com nome '" + nome + "' não encontrado"));
    }

    public List<Plano> buscar() {
        return repository.findAll();
    }

    public void remover(Integer id) {
        repository.deleteById(id);
    }
}
