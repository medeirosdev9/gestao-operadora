package net.weg.gestao_operadora.controller;

import lombok.AllArgsConstructor;
import net.weg.gestao_operadora.model.Contrato;
import net.weg.gestao_operadora.service.ContratoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
@RestController
@RequestMapping("/contratos")
@AllArgsConstructor
public class ContratoController {
    private ContratoService service;

    @PostMapping
    public ResponseEntity<Contrato> cadastro(@RequestBody Contrato contrato) {
        contrato = service.cadastro(contrato);
        return new ResponseEntity<>(contrato, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contrato> edicao(@PathVariable Integer id, @RequestBody Contrato contrato) {
        contrato = service.editar(id, contrato);
        return new ResponseEntity<>(contrato, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contrato> buscarContratoPorId(@PathVariable Integer id) {
        try {
            Contrato contrato = service.buscar(id);
            return new ResponseEntity<>(contrato, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping
    public ResponseEntity<List<Contrato>> buscarContratos() {
        List<Contrato> contratos = service.buscar();
        if (contratos.isEmpty()) {
            return new ResponseEntity<>(contratos, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Contrato> removerContrato(@PathVariable Integer id) {
        service.remover(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/plano/{id}")
    public ResponseEntity<List<Contrato>> buscarContratosPorPlano(@RequestParam Integer idPlano) {
        List<Contrato> contratos = service.buscarContratosPorPlano(idPlano);
        if (contratos.isEmpty()) {
            return new ResponseEntity<>(contratos, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
