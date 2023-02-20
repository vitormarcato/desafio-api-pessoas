package com.attornatus.apipessoas.controllers;

import com.attornatus.apipessoas.models.Pessoa;
import com.attornatus.apipessoas.models.dtos.DadosAtualizacaoPessoa;
import com.attornatus.apipessoas.models.dtos.DadosCadastroPessoa;
import com.attornatus.apipessoas.models.dtos.DadosDetalhamentoPessoa;
import com.attornatus.apipessoas.repositories.PessoaRepository;
import com.attornatus.apipessoas.services.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("pessoas")
public class PessoaController {
    @Autowired
    private PessoaRepository repository;
    @Autowired
    private PessoaService service;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroPessoa dados, UriComponentsBuilder uriBuilder) {
        Pessoa pessoa = new Pessoa(dados);
        service.cadastrarPessoa(pessoa);
        var uri = uriBuilder.path("/pessoas/{id}").buildAndExpand(pessoa.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoPessoa(pessoa));
    }

    @PutMapping("/{pessoaId}/enderecos/{enderecoId}")
    public ResponseEntity atribuirEnderecoParaPessoa(@PathVariable Long pessoaId, @PathVariable Long enderecoId) {
        var pessoa = service.atribuirEnderecoParaPessoa(pessoaId, enderecoId);
        return ResponseEntity.ok(new DadosDetalhamentoPessoa(pessoa));
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var pessoa = service.findById(id).get();
        return ResponseEntity.ok(new DadosDetalhamentoPessoa(pessoa));
    }

    @GetMapping
    public ResponseEntity<List<DadosDetalhamentoPessoa>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @PutMapping
    public ResponseEntity atualizar(@RequestBody DadosAtualizacaoPessoa dados) {
        var pessoa = service.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoPessoa(pessoa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
