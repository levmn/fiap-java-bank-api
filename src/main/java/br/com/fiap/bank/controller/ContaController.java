package br.com.fiap.bank.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.bank.model.Conta;
import br.com.fiap.bank.model.ContaCorrente;
import br.com.fiap.bank.model.ContaPoupanca;
import br.com.fiap.bank.model.ContaSalario;

@RestController
@RequestMapping("/contas")
public class ContaController {

    private List<Conta> contas = new ArrayList<>();
    private Long nextId = 1L;

    private final ClienteController clienteController;

    public ContaController(ClienteController clienteController) {
        this.clienteController = clienteController;
    }

    @GetMapping
    public ResponseEntity<List<Conta>> getAllContas() {
        return ResponseEntity.ok(contas);
    }

    @GetMapping("{id}")
    public ResponseEntity<Conta> getContaById(@PathVariable Long id) {
        Optional<Conta> conta = contas.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();

        return conta.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("corrente")
    public ResponseEntity<ContaCorrente> createContaCorrente(@RequestBody ContaCorrente conta) {
        conta.setId(nextId++);
        conta.setDataAbertura(LocalDate.now());
        conta.setTipoConta("CORRENTE");
        contas.add(conta);
        return ResponseEntity.status(HttpStatus.CREATED).body(conta);
    }

    @PostMapping("poupanca")
    public ResponseEntity<ContaPoupanca> createContaPoupanca(@RequestBody ContaPoupanca conta) {
        conta.setId(nextId++);
        conta.setDataAbertura(LocalDate.now());
        conta.setTipoConta("POUPANCA");
        contas.add(conta);
        return ResponseEntity.status(HttpStatus.CREATED).body(conta);
    }

    @PostMapping("salario")
    public ResponseEntity<ContaSalario> createContaSalario(@RequestBody ContaSalario conta) {
        conta.setId(nextId++);
        conta.setDataAbertura(LocalDate.now());
        conta.setTipoConta("SALARIO");
        contas.add(conta);
        return ResponseEntity.status(HttpStatus.CREATED).body(conta);
    }

    @PutMapping("{id}")
    public ResponseEntity<Conta> updateConta(@PathVariable Long id, @RequestBody Conta contaAtualizada) {
        Optional<Conta> contaExistente = contas.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();

        if (contaExistente.isPresent()) {
            Conta conta = contaExistente.get();
            conta.setNumero(contaAtualizada.getNumero());
            conta.setAgencia(contaAtualizada.getAgencia());
            conta.setAtiva(contaAtualizada.isAtiva());

            return ResponseEntity.ok(conta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deactivateConta(@PathVariable Long id) {
        Optional<Conta> contaOpt = contas.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();

        if (contaOpt.isPresent()) {
            Conta conta = contaOpt.get();
            conta.setAtiva(false);
            return ResponseEntity.ok("Conta desativada com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
