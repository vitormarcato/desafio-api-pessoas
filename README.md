# Desafio Back-End - API Pessoas
<div id="sobre">
Uma API simples, usando Spring Boot, para gerenciar Pessoas.
</div>

---

![](https://media.giphy.com/media/giDUrT9SAdjwB9rsJu/giphy.gif#vitrinedev)

## Objetivo
O objetivo é identificar os conhecimentos quanto às tecnologias utilizadas no cotidiano de desenvolvimento de uma equipe Back-end.

## Desafio

Usando Spring boot, crie uma API simples para gerenciar Pessoas. Esta API deve permitir:  
  
  •	Criar uma pessoa
  
  •	Editar uma pessoa
  
  •	Consultar uma pessoa
  
  •	Listar pessoas
  
  •	Criar endereço para pessoa
  
  •	Listar endereços da pessoa
  
  •	Poder informar qual endereço é o principal da pessoa  
  

Uma Pessoa deve ter os seguintes campos:  
  
  -	Nome
  
  -	Data de nascimento
  
  -	Endereço
  
     -	Logradouro
     -	CEP
     -	Número
     -	Cidade


Requisitos  
 
  •	Todas as respostas da API devem ser JSON  
  •	Banco de dados H2
  
## Resolução
  
  Para o desenvolvimento do projeto, considerei as premissas:

  1.	Uma pessoa pode ter mais de um endereco e um endereco pode ter mais de uma pessoa, no caso de uma familia, por exemplo
  2.	Não deve haver duplicidades de registro.

### Diagramas
---

### Arquitetura:
![image](https://user-images.githubusercontent.com/60930603/220412598-2a4a8242-206b-4f40-8ffb-7fda07f1e869.png)


### Relacionamento das entidades Many-To-Many:
![Diagrama ER](https://user-images.githubusercontent.com/60930603/220413007-a6c507a8-136c-4b82-8de7-f1657ebccbc5.png)

### Tecnologias
---

  - Java 17
  
  - Spring Boot   
  
    - JPA/Hibernate

    - Spring Web MVC

    - SpringDoc

    - Bean Validation

    - Lombok

    - Mockito

    - JUnit
  
  - Maven
  
  - Postman
  
  - H2 (Banco de dados Relacional)  

## Deploy
Deploy da aplicação feita na Amazon Web Services (EC2)

---

### Dependencias 

Java 17

Maven 3.9.0

<div id="run">
## Como Executar 

1. Clonar o repositório
  
  ```bash
git clone https://github.com/vitormarcato/desafio-api-pessoas.git
```
ou fazer download do .zip file
  		  
2. Na pasta do projeto "desafio-api-pessoas" faça o build utilizando o maven: 

  ```bash
mvn clean package
```

3.  Na sequência, na pasta /target execute o arquivo .jar:
  
  ```bash
java -jar api-pessoas-0.0.1-SNAPSHOT.jar
```
</div>

## Documentação 

Ao executar o projeto é possível verificar a documentação na URL abaixo:

```
http://localhost:8080/swagger-ui/index.html#/
``` 
---

## Funcionalidades 

**POST Criar Pessoa**

Parâmetros
```
 http://localhost:8080/pessoas
```

Request Body - Json
```json
{
    "nome":"alberto",
    "dataNascimento":"2000-02-02"
}
```
**PUT Editar uma Pessoa**  (é possível informar qual endereço é o principal)

Parâmetros
```
http://localhost:8080/pessoas
```
Request Body - Json
```json
{
        "id": 1,
        "nome": "renato",
        "dataNascimento": "2000-02-02",
        "principal": 1
}
```
**PUT Atribuir Endereco Para Pessoa** (permite atribuir um endereco cadastrado à uma pessoa já cadastrada)

Parâmetros
```
http://localhost:8080/pessoas/{id_pessoa}/enderecos/{id_endereco}
```

**GET Consultar uma Pessoa**  

Parâmetros
```
http://localhost:8080/pessoas/{id}
```


**GET Listar pessoas e enderecos da pessoa**  

Parâmetros
```
http://localhost:8080/pessoas
```

**DELETE Excluir pessoa**  

Parâmetros
```
http://localhost:8080/pessoas/{id}
```

**POST Criar endereco**  

Parâmetros
```
http://localhost:8080/enderecos
```
Request Body - Json
```json
{
        "logradouro":"rua 1",
        "cep":"12345671",
        "numero":"1",
        "cidade":"São Paulo"
}
```
**DELETE Excluir endereco**  

Parâmetros
```
http://localhost:8080/enderecos/{id}
```

---
## VitrineDev - Alura
---
| :placard: Vitrine.Dev | https://cursos.alura.com.br/vitrinedev/vitormarcato     |
| -------------  | --- |
| :sparkles: Nome        | **Desafio Back-End - API Pessoas**
| :label: Tecnologias | java, Spring Boot, Maven, Postman, H2, AWS EC2, JPA-Hibernate, Lombok, JUnit, Mockito, Bean Validation
| :rocket: URL         | Veja como executar no link: [**Executar**](#run)
| :fire: Desafio     | Veja no link: [**Sobre**](#sobre)

---
### Qualidade de código

1.	Durante a implementação de uma nova funcionalidade de software solicitada, quais critérios você avalia e implementa para garantia de qualidade de software?

Na minha opinião, a fase do planejamento é muito importante para garantir a qualidade de software ao implementar uma nova funcionalidade, em especial o levantamento e análise dos requisitos que é fundamental nesse processo. Além disso, questões como confiabilidade, usabilidade, manutenção, segurança, testes e satisfação do cliente devem ser considerados e avaliados.

2.	Em qual etapa da implementação você considera a qualidade de software?

A qualidade de software é percebida de diversas maneiras e de formas diferentes pelas pessoas. Na minha opinião a qualidade de software deve ser considerada em todas as etapas do ciclo de vida de um software, desde o início do projeto com o levantamento de requisitos e regras de negócio, passando por boas práticas no desenvolvimento do código fonte e também pelas entregas até chegar na manutenção do sistema. Importante comentar que garantir a qualidade de software em um projeto é uma maneira de diminuir custos.

---

### Autor

Vitor Marcato https://www.linkedin.com/in/vitormarcato/
