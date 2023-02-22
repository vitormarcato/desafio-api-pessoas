# Desafio Back-End - API Pessoas

Uma API simples, usando Spring Boot, para gerenciar Pessoas.

![](https://media.giphy.com/media/giDUrT9SAdjwB9rsJu/giphy.gif)

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

## Executar em Máquina Local

1. Clonar o repositório
  
  ```bash
git clone https://github.com/vitormarcato/desafio-api-pessoas.git
```
ou fazer download do .zip file
  		  
2. Na pasta do projeto "desafio-api-pessoas" faça o build utilizando o macven: 

  ```bash
mvn clean package
```

3.  Na sequência, na pasta /target execute o arquivo .jar:
  
  ```bash
java -jar api-pessoas-0.0.1-SNAPSHOT.jar
```

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

### Autor

Vitor Marcato https://www.linkedin.com/in/vitormarcato/
