package net.weg.gestao_operadora.controller;

import lombok.AllArgsConstructor;
import net.weg.gestao_operadora.model.Cliente;
import net.weg.gestao_operadora.model.Plano;
import net.weg.gestao_operadora.model.ServicoAdicional;
import net.weg.gestao_operadora.repository.ServicoRepository;
import net.weg.gestao_operadora.service.ServicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/servicos")
@AllArgsConstructor
public class ServicoController {
    private ServicoService service;

    @PostMapping
    public ResponseEntity<ServicoAdicional> cadastro(@RequestBody ServicoAdicional servicoAdicional) {
        servicoAdicional = service.cadastro(servicoAdicional);
        return new ResponseEntity<>(servicoAdicional, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServicoAdicional> edicao(@PathVariable Integer id, @RequestBody ServicoAdicional servicoAdicional) {
        servicoAdicional = service.editar(id, servicoAdicional);
        return new ResponseEntity<>(servicoAdicional, HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<ServicoAdicional> alterarDescricao(@RequestParam Integer id, @RequestParam String descricao) {
        try {
            ServicoAdicional servicoAdicional = service.alterarDescricao(id, descricao);
            return new ResponseEntity<>(servicoAdicional, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicoAdicional> buscarServicoPorId(@PathVariable Integer id) {
        try {
            ServicoAdicional servicoAdicional = service.buscar(id);
            return new ResponseEntity<>(servicoAdicional, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping
    public ResponseEntity<List<ServicoAdicional>> buscarServicos() {
        List<ServicoAdicional> servicoAdicionals = service.buscar();
        if (servicoAdicionals.isEmpty()) {
            return new ResponseEntity<>(servicoAdicionals, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ServicoAdicional> removerServico(@PathVariable Integer id) {
        service.remover(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
