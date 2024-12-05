package net.weg.gestao_operadora.controller;

import lombok.AllArgsConstructor;
import net.weg.gestao_operadora.controller.dto.PlanoServicoRequestDTO;
import net.weg.gestao_operadora.model.Plano;
import net.weg.gestao_operadora.model.PlanoServico;
import net.weg.gestao_operadora.service.PlanoService;
import net.weg.gestao_operadora.service.PlanoServicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("plano_servico")
@AllArgsConstructor
public class PlanoServicoController {
    private PlanoServicoService service;

    @PostMapping
    public ResponseEntity<PlanoServico> cadastro(@RequestBody PlanoServicoRequestDTO dto) {
        try {
            PlanoServico planoServico = service.cadastro(dto);
            return new ResponseEntity<>(planoServico, HttpStatus.CREATED);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanoServico> edicao(@PathVariable Integer id, @RequestBody PlanoServicoRequestDTO dto) {
        try {
            PlanoServico planoServico = service.edicao(id, dto);
            return new ResponseEntity<>(planoServico, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PlanoServico> remover(@PathVariable Integer id) {
        service.remover(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/plano/{id}")
    public ResponseEntity<List<PlanoServico>> buscarPorPlano(@PathVariable Integer planoId) {
        List<PlanoServico> planoServicos= service.buscarPorPlano(planoId);
        if (!planoServicos.isEmpty()) {
            return new ResponseEntity<>(planoServicos, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/servico/{id}")
    public ResponseEntity<List<PlanoServico>> buscarPorServico(@PathVariable Integer servicoId) {
        List<PlanoServico> planoServicos= service.buscarPorServico(servicoId);
        if (!planoServicos.isEmpty()) {
            return new ResponseEntity<>(planoServicos, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
