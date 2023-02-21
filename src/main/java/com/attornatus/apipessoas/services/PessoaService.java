package com.attornatus.apipessoas.services;

import com.attornatus.apipessoas.dtos.DadosAtualizacaoPessoa;
import com.attornatus.apipessoas.dtos.DadosListagemPessoa;
import com.attornatus.apipessoas.entities.Endereco;
import com.attornatus.apipessoas.entities.Pessoa;
import com.attornatus.apipessoas.repositories.EnderecoRepository;
import com.attornatus.apipessoas.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Transactional
    public Pessoa cadastrarPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public Optional<Pessoa> findById(Long id) {
        return pessoaRepository.findById(id);
    }

    public List<DadosListagemPessoa> listar() {
        return pessoaRepository.findAll().stream().map(DadosListagemPessoa::new).toList();
    }

    @Transactional
    public Pessoa atribuirEnderecoParaPessoa(Long pessoaId, Long enderecoId) {
        Pessoa pessoa = pessoaRepository.findById(pessoaId).get();
        Endereco endereco = enderecoRepository.findById(enderecoId).get();
        pessoa.getEnderecos().add(endereco);
        endereco.getPessoasNoEndereco().add(pessoa);
        return pessoaRepository.save(pessoa);
    }

    @Transactional
    public Pessoa atualizarInformacoes(DadosAtualizacaoPessoa dados) {

        if (!pessoaRepository.existsById(dados.id())) {
            throw new RuntimeException("Pessoa nao cadastrada");
        }
        var pessoa = findById(dados.id()).get();

        if (dados.nome() != null) {
            pessoa.setNome(dados.nome());
        }

        if (dados.nascimento() != null) {
            pessoa.setNascimento(dados.nascimento());
        }

        if (dados.principal() != null && (!enderecoRepository.existsById(dados.principal()))) {
            throw new RuntimeException("Endereco nao cadastrado");
        }
        pessoa.setPrincipal(dados.principal());

        return cadastrarPessoa(pessoa);
    }

    @Transactional
    public void excluir(Long id) {
        if (!pessoaRepository.existsById(id)) {
            throw new RuntimeException("Pessoa nao cadastrada");
        }
        pessoaRepository.deleteById(id);
    }
}
