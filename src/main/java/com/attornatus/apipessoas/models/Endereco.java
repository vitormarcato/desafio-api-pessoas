package com.attornatus.apipessoas.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Table(name = "tb_enderecos")
@Entity(name = "Endereco")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String logradouro;

    private String cep;

    private String numero;

    private String cidade;

    private Boolean enderecoPrincipal;

    @JsonIgnore
    @ManyToMany(mappedBy = "enderecos")
    private Set<Pessoa> pessoasNoEndereco = new HashSet<>();

    public Endereco(DadosCadastroEndereco dados) {
        this.logradouro = dados.logradouro();
        this.cep = dados.cep();
        this.numero = dados.numero();
        this.cidade = dados.cidade();
        this.enderecoPrincipal = dados.enderecoPrincipal();

    }

    public void atualizarInformacoes(DadosAtualizacaoEndereco dados){
        if (dados.logradouro() != null) {
            this.logradouro = dados.logradouro();
        }
        if (dados.cep() != null) {
            this.cep = dados.cep();
        }
        if (dados.numero() != null) {
            this.numero = dados.numero();
        }
        if (dados.cidade() != null) {
            this.cidade = dados.cidade();
        }
        if (dados.enderecoPrincipal() != null) {
            this.enderecoPrincipal = dados.enderecoPrincipal();
        }
    }
}
