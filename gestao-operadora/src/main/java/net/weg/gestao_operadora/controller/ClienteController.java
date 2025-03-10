package net.weg.gestao_operadora.controller;

import lombok.AllArgsConstructor;
import net.weg.gestao_operadora.model.Cliente;
import net.weg.gestao_operadora.model.Plano;
import net.weg.gestao_operadora.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/clientes")
@AllArgsConstructor
public class ClienteController {
    private ClienteService service;

    @PostMapping
    public ResponseEntity<Cliente> cadastro(@RequestBody Cliente cliente) {
        cliente = service.cadastro(cliente);
        return new ResponseEntity<>(cliente, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> edicao(@PathVariable Integer id, @RequestBody Cliente cliente) {
        cliente = service.editar(id, cliente);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarClientePorId(@PathVariable Integer id) {
        try {
            Cliente cliente = service.buscar(id);
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> removerCliente(@PathVariable Integer id) {
        service.remover(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping("/plano/{planoId}")
    public List<Cliente> buscarClientesPorPlano(@PathVariable Integer planoId) {
        Plano plano = new Plano();
        plano.setId(planoId);
        return service.buscarClientesPorPlano(plano);
    }
}
