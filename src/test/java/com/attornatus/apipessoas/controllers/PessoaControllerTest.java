package com.attornatus.apipessoas.controllers;

import com.attornatus.apipessoas.dtos.DadosCadastroPessoa;
import com.attornatus.apipessoas.dtos.DadosDetalhamentoPessoa;
import com.attornatus.apipessoas.dtos.DadosListagemPessoa;
import com.attornatus.apipessoas.entities.Pessoa;
import com.attornatus.apipessoas.services.PessoaService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class PessoaControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<DadosCadastroPessoa> dadosCadastroPessoaJson;

    @Autowired
    private JacksonTester<DadosDetalhamentoPessoa> dadosDetalhamentoPessoaJson;

    @Autowired
    private JacksonTester<DadosListagemPessoa> dadosListagemPessoaJson;

    @MockBean
    private PessoaService service;

    private LocalDate data = LocalDate.of(1990, 02, 01);

    @Test
    @DisplayName("Deve devolver código http 400 quando informacoes estao invalidas")
    void cadastrarRetornaBadRequestComInformacoesInvalidas() throws Exception {
        var response = mvc.perform(MockMvcRequestBuilders.post("/pessoas"))
                .andReturn().getResponse();

        Assertions.assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deve devolver código http 200 quando informacoes estao validas")
    void cadastrarPessoaRetornaOkComInformacoesValidas() throws Exception {

        var dadosCadastro = new DadosCadastroPessoa("pessoa", data);

        when(service.cadastrarPessoa(any())).thenReturn(new Pessoa(dadosCadastro));

        var response = mvc.perform(MockMvcRequestBuilders.post("/pessoas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(dadosCadastroPessoaJson.write(dadosCadastro).getJson())).andReturn().getResponse();

        var dadosDetalhamento = new DadosDetalhamentoPessoa(null, dadosCadastro.nome(), dadosCadastro.nascimento());

        var jsonEsperado = dadosDetalhamentoPessoaJson.write(dadosDetalhamento).getJson();

        Assertions.assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
        Assertions.assertThat(response.getContentAsString()).isEqualTo(jsonEsperado);
    }

    @Test
    void atribuirEnderecoParaPessoa() {

    }

    @Test
    @DisplayName("Deve devolver código http 200 quando informacoes estao validas")
    void detalharRetornaDadosCompletosDaPessoaComCodigoHttp200() throws Exception {
//
//        var listaPessoa = new DadosListagemPessoa(null, "pessoa", data,  dadosListagemPessoaJson, 1);
//
//        var response = mvc.perform(MockMvcRequestBuilders.get("/pessoas/{id}"))
//                .andReturn().getResponse();
//
//        Assertions.assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
//
//        var dadosDetalhamento = new DadosDetalhamentoPessoa(null, dadosCadastro.nome(), dadosCadastro.nascimento());
//
//        var jsonEsperado = dadosDetalhamentoPessoaJson.write(dadosDetalhamento).getJson();
//
//
    }

    @Test
    void listar() {
    }

    @Test
    void atualizar() {
    }

    @Test
    void excluir() {
    }
}