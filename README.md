# App Social Network
Projeto criado com base em uma aplicação simples.

1. **Instalação de Dependências:**

```bash
mvn install
```

Este comando irá baixar as dependências do projeto e construir o projeto. Ele executa as fases `compile`, `test`, e `package` do ciclo de vida do Maven. O artefato construído geralmente será colocado no diretório `target` do projeto.

2. **Configuração do Banco de Dados MySQL:**

- Instale o [MySQL Workbench](https://dev.mysql.com/downloads/workbench/)
- Configure a senha do banco de dados no arquivo `src/main/resources/application.properties` na propriedade `spring.datasource.password`. Esta senha deve corresponder a mesma configurada no MySQL Workbench.
- Configure o usuário do banco de dados no arquivo `src/main/resources/application.properties` na propriedade `spring.datasource.username`. Este usuário deve corresponder o mesmo configurado no MySQL Workbench.
- Abra o MySQL Workbench e crie um **SCHEMAS** chamado ``social_network`` somente assim a aplicação fara a conexão com o database ou se preferir baixe [social_network](https://drive.google.com/file/d/1IqB_6EZFmNIcHX3uarwIGCbmwb34ZW8z/view?usp=drive_link) e importe.
- **Observação:** O MySQL Workbench deve sempre está aberto.

3. **Execução do Projeto:**

- Use o seguinte comando para executar o projeto:

```bash
mvn spring-boot:run
```

- Se quiser parar de executar aperte as teclas ```ctrl + c``` 
- Se no terminal perguntar ``Deseja finalizar o arquivo em lotes (S/N)?`` responda ``S``

4. **Configuração de requisições HTTP**

- Instale o [Insominia](https://insomnia.rest/)
- configure e importe dentro do Insominia o projeto [Social Network](https://drive.google.com/drive/folders/1DhlHWl9MLa2UqWuI5BDdnQJ5FctXjkAG?usp=sharing)
- Agora com esse projeto é póssivel fazer as requisições necessárias para um CRUD

5. **Limpeza do Projeto:**

```bash
mvn clean
```

Este comando remove os arquivos gerados durante a compilação e construção do projeto. Isso é útil se você deseja limpar o projeto antes de construir novamente.
