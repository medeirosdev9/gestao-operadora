package net.weg.gestao_operadora.service;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import net.weg.gestao_operadora.model.Cliente;
import net.weg.gestao_operadora.model.Plano;
import net.weg.gestao_operadora.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClienteService {
    private ClienteRepository repository;

    public Cliente cadastro(Cliente cliente) {
        return repository.save(cliente);
    }

    public Cliente editar(Integer id, Cliente cliente) {
        cliente.setId(id);
        return repository.save(cliente);
    }

    public Cliente buscar(Integer id) {
        Optional<Cliente> cliente = repository.findById(id);
        return cliente.orElseThrow(() -> new NoSuchElementException("Cliente não encontrado"));
    }

    public void remover(Integer id) {
        repository.deleteById(id);
    }

    public List<Cliente> buscarClientesPorPlano(Plano plano) {
        return repository.findByPlanoId(plano.getId());
    }


}