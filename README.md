# Social Network API

<div align="center">

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow)](https://opensource.org/licenses/MIT)
[![Java Version](https://img.shields.io/badge/Java-21%2B-blue)](https://www.java.com/)
[![GitHub repo size](https://img.shields.io/github/repo-size/marllonmendez/stories?color=blue)]()
[![GitHub code size in bytes](https://img.shields.io/github/languages/code-size/marllonmendez/stories?color=blue)]()

[![Sprinb Boot](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot)](https://spring.io/projects/spring-boot)
[![Hinernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)](https://hibernate.org/)
[![Maven](https://img.shields.io/badge/apache_maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)](https://maven.apache.org/)
[![My SQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)](https://www.mysql.com/)

</div>

## Sobre
Projeto criado com base em uma aplicação simples para trabalho da faculdade.

## Funcionalidades

#### User:

- Criarção de usuário;
- Listagem de todos os usuários;
- Pesquisa por Id do usuário;
- Remoção de usuário por id.

#### Post:

- Criarção de postagem;
- Listagem de todas as postagens;
- Pesquisa por Id de postagem;
- Remoção de postagem por id.

<h4>1. Instalação de Dependências:</h4>

```bash
mvn install
```

Este comando irá baixar as dependências do projeto e construir o projeto. Ele executa as fases `compile`, `test`, e `package` do ciclo de vida do Maven.

<h4>2. Configuração do Banco de Dados MySQL:</h4>

- Instale o [MySQL Workbench](https://dev.mysql.com/downloads/workbench/)
- Configure a senha do banco de dados no arquivo `src/main/resources/application.properties` na propriedade `spring.datasource.password`. Esta senha deve corresponder a mesma configurada no MySQL Workbench.
- Configure o usuário do banco de dados no arquivo `src/main/resources/application.properties` na propriedade `spring.datasource.username`. Este usuário deve corresponder o mesmo configurado no MySQL Workbench.
- Abra o MySQL Workbench e crie um **SCHEMAS** chamado ``social_network`` somente assim a aplicação fara a conexão com o database ou se preferir baixe [social_network](https://drive.google.com/file/d/1IqB_6EZFmNIcHX3uarwIGCbmwb34ZW8z/view?usp=drive_link) e importe.
- **Observação:** O MySQL Workbench deve sempre está aberto.

<h4>3. Execução do Projeto:</h4>

- Use o seguinte comando para executar o projeto:

```bash
mvn spring-boot:run
```

- Se quiser parar de executar aperte as teclas ```ctrl + c``` 
- Se no terminal perguntar ``Deseja finalizar o arquivo em lotes (S/N)?`` responda ``S``

<h4>4. Configuração de requisições HTTP (Para Testes):</h4>

- Instale o [Insominia](https://insomnia.rest/)
- configure e importe dentro do Insominia o projeto [Social Network](https://drive.google.com/drive/folders/1DhlHWl9MLa2UqWuI5BDdnQJ5FctXjkAG?usp=sharing)
- Agora com esse projeto é póssivel fazer as requisições necessárias para um CRUD

<h4>5. Limpeza do Projeto:</h4>

```bash
mvn clean
```

Este comando remove os arquivos gerados durante a compilação e construção do projeto. Isso é útil se você deseja limpar o projeto antes de construir novamente.

## Licença

Este projeto está licenciado sob a [Licença MIT](LICENSE).
