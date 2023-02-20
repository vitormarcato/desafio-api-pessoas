package com.attornatus.apipessoas.services;

import com.attornatus.apipessoas.models.Endereco;
import com.attornatus.apipessoas.models.dtos.DadosAtualizacaoEndereco;
import com.attornatus.apipessoas.models.dtos.DadosDetalhamentoEndereco;
import com.attornatus.apipessoas.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Transactional
    public Endereco cadastrarEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public Optional<Endereco> findById(Long id) {
        return enderecoRepository.findById(id);
    }

    public List<DadosDetalhamentoEndereco> listar() {
        return enderecoRepository.findAll().stream().map(DadosDetalhamentoEndereco::new).toList();
    }

    @Transactional
    public Endereco atualizarInformacoes(DadosAtualizacaoEndereco dados) {

        if (!enderecoRepository.existsById(dados.id())) {
            throw new RuntimeException("Endereco nao cadastrado");
        }
        var endereco = findById(dados.id()).get();

        if (dados.logradouro() != null) {
            endereco.setLogradouro(dados.logradouro());
        }

        if (dados.cep() != null) {
            endereco.setCep(dados.cep());
        }

        if (dados.numero() != null) {
            endereco.setNumero(dados.numero());
        }
        if (dados.cidade() != null) {
            endereco.setCidade(dados.cidade());
        }
        return cadastrarEndereco(endereco);
    }

    @Transactional
    public void excluir(Long id) {
        if (!enderecoRepository.existsById(id)) {
            throw new RuntimeException("Endereco nao cadastrado");
        }
        enderecoRepository.deleteById(id);
    }
}
