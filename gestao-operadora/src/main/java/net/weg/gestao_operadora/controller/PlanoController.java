package net.weg.gestao_operadora.controller;

import lombok.AllArgsConstructor;
import net.weg.gestao_operadora.model.Plano;
import net.weg.gestao_operadora.service.PlanoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/planos")
@AllArgsConstructor
public class PlanoController {
    private PlanoService service;


    @PostMapping
    public ResponseEntity<Plano> cadastrarPlano(@RequestBody Plano plano) {
        plano = service.cadastro(plano);
        return new ResponseEntity<>(plano, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plano> edicaoPlano(@PathVariable Integer id, @RequestBody Plano plano) {
        plano = service.editar(id, plano);
        return new ResponseEntity<>(plano, HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<Plano> alterarValor(@RequestParam Integer id, @RequestParam double valor) {
        try {
            Plano plano = service.alterarValor(id, valor);
            return new ResponseEntity<>(plano, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Plano> buscarPlanoPorId(@PathVariable Integer id) {
        try {
            Plano plano = service.buscar(id);
            return new ResponseEntity<>(plano, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<Plano> buscarPlanoPorNome(@PathVariable String nome) {
        try {
            Plano plano = service.buscar(nome);
            return new ResponseEntity<>(plano, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping
    public ResponseEntity<List<Plano>> buscarPlanos() {
        List<Plano> planos = service.buscar();
        if (!planos.isEmpty()) {
            return new ResponseEntity<>(planos, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Plano> removerPlano(@PathVariable Integer id) {
        service.remover(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
