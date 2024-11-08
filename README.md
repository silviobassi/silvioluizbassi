# Projeto Desenvolvido na Pós-graduação em Arquitetura de Software Infnet

## Disciplina Arquitetura Java [24E4_2]

Este projeto é um Sistema de Gerenciamento de Matrículas construído com Spring Boot.

## Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Data JPA
- Spring Validation
- Maven
- H2 Database
- Swagger (Springdoc-Openapi)

## Modelagem do Domínio - Diagrama de Classes

![img.png](domain-class-diagram.png)

## Features

- **Gerenciamento de Matrículas**: Adicionar, atualizar, excluir e listar matrículas.
- **Gerenciamento de Instrutores**: Adicionar, atualizar, excluir e listar instrutores.
- **Gerenciamento de Alunos**: Adicionar, atualizar, excluir e listar alunos.
- **Gerenciamento de Cursos**: listar cursos por faixa de preços e atualizar preços de cursos.
- **Gerenciamento de Bootcamps**: Adicionar, atualizar, excluir e listar bootcamps.
- **Gerenciamento de Especializações**: Adicionar, atualizar, excluir e listar especializações.
- **Integração com Swagger**: Documentação e teste da API usando Swagger UI.

## Executando a Aplicação

### Pré-requisitos

- Java 17 ou superior
- Maven

### Instalação

1. Clone o repositório:
    ```sh
    git clone https://github.com/silviobassi/silvioluizbassi.git
    cd silvioluizbassi
    ```

2. Build o projeto:
    ```sh
    mvn clean install
    ```

3. Execute a aplicação:
    ```sh
    mvn spring-boot:run
    ```

### Acessando a Aplicação

- A aplicação está disponível em `http://localhost:8080/`.
- O Swagger UI pode ser acessado em `http://localhost:8080/swagger-ui/index.html`.

## Configuração

### Database

A aplicação utiliza H2 in-memory database por padrão. Você pode configurar o banco de dados no arquivo
`application.yml`.

## Utilização

### API Endpoints

Os arquivos para executar os endpoints em um client como Postman estão disponíveis em `./PostmanEndpoints`.

- **Matrículas**
    - ![GET](https://img.shields.io/badge/GET-green) `/matriculas/listar`: Lista todas as matrículas
    - ![POST](https://img.shields.io/badge/POST-blue) `/matriculas/criar`: Cria uma nova matrícula
    - ![PUT](https://img.shields.io/badge/PUT-yellow) `/matriculas/1/atualizar`: Atualiza uma matrícula
    - ![GET](https://img.shields.io/badge/GET-green) `/matriculas/2/buscar`: Recupera uma matrícula por ID
    - ![DELETE](https://img.shields.io/badge/DELETE-red) `/matriculas/1/excluir`: Exclui uma matrícula por ID

- **Instrutores**
    - ![GET](https://img.shields.io/badge/GET-green) `/instrutores/listar`: Lista todos os instrutores
    - ![POST](https://img.shields.io/badge/POST-blue) `/instrutores/criar`: Cria um novo instrutor
    - ![PUT](https://img.shields.io/badge/PUT-yellow) `/instrutores/1/atualizar`: Atualiza um instrutor
    - ![GET](https://img.shields.io/badge/GET-green) `/instrutores/2/buscar`: Recupera um instrutor por ID
    - ![DELETE](https://img.shields.io/badge/DELETE-red) `/instrutores/3/excluir`: Exclui um instrutor por ID

- **Alunos**
    - ![GET](https://img.shields.io/badge/GET-green) `/alunos/listar`: Lista todos os alunos
    - ![POST](https://img.shields.io/badge/POST-blue) `/alunos/criar`: Cria um novo aluno
    - ![PUT](https://img.shields.io/badge/PUT-yellow) `/alunos/1/atualizar`: Atualiza um aluno
    - ![GET](https://img.shields.io/badge/GET-green) `/alunos/2/buscar`: Recupera um aluno por ID
    - ![DELETE](https://img.shields.io/badge/DELETE-red) `/alunos/2/excluir`: Exclui um aluno por ID

- **Cursos**
    - ![GET](https://img.shields.io/badge/GET-green) `/cursos/listar`: Lista todos os cursos
    - ![GET](https://img.shields.io/badge/GET-green) `/cursos/listarPorPrecos?precoInicial=6650&precoFinal=7000`: Lista todos os cursos por faixa de preço
    - ![PATCH](https://img.shields.io/badge/PATCH-lightgreen) `/cursos/preco/atualizar`: Atualiza o preço de um curso

- **Bootcamps**
    - ![GET](https://img.shields.io/badge/GET-green) `/bootcamps/listar`: Lista todos os bootcamps
    - ![POST](https://img.shields.io/badge/POST-blue) `/bootcamps/criar`: Cria um novo bootcamp
    - ![PUT](https://img.shields.io/badge/PUT-yellow) `/bootcamps/1/atualizar`: Atualiza um bootcamp
    - ![GET](https://img.shields.io/badge/GET-green) `/bootcamps/3/buscar`: Recupera um bootcamp por ID
    - ![DELETE](https://img.shields.io/badge/DELETE-red) `/bootcamps/1/excluir`: Exclui um bootcamp por ID

- **Especializacao**
    - ![GET](https://img.shields.io/badge/GET-green) `/especializacoes/listar`: Lista todas as especializações
    - ![POST](https://img.shields.io/badge/POST-blue) `/especializacoes/criar`: Cria uma nova especialização
    - ![PUT](https://img.shields.io/badge/PUT-yellow) `/especializacoes/4/atualizar`: Atualiza uma especialização
    - ![GET](https://img.shields.io/badge/GET-green) `/especializacoes/3/buscar`: Recupera uma especialização por ID
    - ![DELETE](https://img.shields.io/badge/DELETE-red) `/especializacoes/2/excluir`: Exclui uma especialização por ID

---
![Silvio Luiz Bassi](https://img.shields.io/badge/Developed%20by-Silvio%20Luiz%20Bassi-orange)

![GitHub](https://img.shields.io/badge/GitHub-GestaoMatriculas-blue?logo=github)
![Status](https://img.shields.io/badge/Status-Concluído-green)