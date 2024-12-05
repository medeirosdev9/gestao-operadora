package net.weg.gestao_operadora.service;

import lombok.AllArgsConstructor;
import net.weg.gestao_operadora.model.Contrato;
import net.weg.gestao_operadora.repository.ContratoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ContratoService {
    private ContratoRepository repository;

    public Contrato cadastro(Contrato contrato) {
        return repository.save(contrato);
    }


    public Contrato editar(Integer id, Contrato contrato) {
        contrato.setId(id);
        return repository.save(contrato);
    }


    public Contrato buscar(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Contrato não encontrado"));
    }

    public List<Contrato> buscar() {
        return repository.findAll();
    }


    public void remover(Integer id) {
        repository.deleteById(id);
    }

    public List<Contrato> buscarContratosPorPlano(Integer idPlano) {
        return repository.findAllByPlano_Id(idPlano);
    }
}
