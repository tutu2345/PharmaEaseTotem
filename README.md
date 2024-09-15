Aqui está a versão atualizada do seu **README.md** com links de navegação internos:

---

# PharmaEaseTotem

**PharmaEaseTotem** é uma API desenvolvida com Spring Boot para gerenciamento de dados farmacêuticos. Esta API é empacotada em um contêiner Docker e está configurada para ser implantada em uma máquina virtual Windows 10 no Azure, com um banco de dados Azure SQL.

## Tabela de Conteúdos

- [Estrutura do Projeto](#estrutura-do-projeto)
- [Pré-requisitos](#pré-requisitos)
- [Configuração do Ambiente](#configuração-do-ambiente)
  - [Clonando o Repositório](#clonando-o-repositório)
  - [Construindo a Imagem Docker](#construindo-a-imagem-docker)
  - [Executando a Aplicação Localmente com Docker](#executando-a-aplicação-localmente-com-docker)
- [Configuração do Azure](#configuração-do-azure)
  - [Criar e Configurar a VM no Azure](#criar-e-configurar-a-vm-no-azure)
  - [Configurar GitHub Actions](#configurar-github-actions)
- [Deploy da Aplicação](#deploy-da-aplicação)
  - [Configuração do Workflow GitHub Actions](#configuração-do-workflow-github-actions)
  - [Passos de Deploy](#passos-de-deploy)
- [Testes da API](#testes-da-api)
  - [Endpoints CRUD](#endpoints-crud)
- [Scripts JSON CRUD](#scripts-json-crud)
- [Equipe de Desenvolvimento](#equipe-de-desenvolvimento)
- [Cronograma de Desenvolvimento](#cronograma-de-desenvolvimento)
- [Instrução de como Rodar a Aplicação](#instrução-de-como-rodar-a-aplicação)
- [Link do Vídeo](#link-do-vídeo)
- [Público-Alvo](#público-alvo)
- [Problemas que a Aplicação se Propõe a Solucionar](#problemas-que-a-aplicação-se-propõe-a-solucionar)
- [Evolução em Comparação à Entrega da Sprint Anterior](#evolução-em-comparação-à-entrega-da-sprint-anterior)
- [Diagrama](#diagrama)
- [Licença](#licença)
- [Contato](#contato)

## Estrutura do Projeto

- **Código Fonte**: Diretório `src` contendo o código da aplicação.
- **Dockerfile**: Arquivo para construir a imagem Docker.
- **Maven Configuration**: Arquivo `pom.xml` para dependências e construção do projeto.
- **Scripts JSON**: Scripts para operações CRUD na API.

## Pré-requisitos

Antes de iniciar, certifique-se de ter os seguintes pré-requisitos instalados:

- [JDK 11](https://openjdk.java.net/projects/jdk/11/)
- [Maven](https://maven.apache.org/)
- [Docker](https://www.docker.com/get-started)
- [Git](https://git-scm.com/)
- Acesso ao [Docker Hub](https://hub.docker.com/) e ao [Azure](https://azure.microsoft.com/)

## Configuração do Ambiente

### Clonando o Repositório

```bash
git clone https://github.com/RamonReserva/PharmaEaseTotem.git
cd pharmaease-totem
```

### Construindo a Imagem Docker

1. Certifique-se de que o Docker está instalado e em execução.
2. Navegue até o diretório do projeto onde está localizado o `Dockerfile`.
3. Execute o seguinte comando para construir a imagem Docker:

```bash
docker build -t pharmaease-totem .
```

### Executando a Aplicação Localmente com Docker

Para testar a aplicação localmente, execute:

```bash
docker run -d -p 8080:8080 --name pharmaease-totem pharmaease-totem
```

A aplicação estará acessível em `http://localhost:8080`.

## Configuração do Azure

### Criar e Configurar a VM no Azure

1. Acesse o [Azure Portal](https://portal.azure.com/).
2. Crie uma nova VM com Windows 10.
3. Instale o Docker Desktop na VM.
4. Configure o firewall para permitir acesso às portas 22 (SSH) e 8080.

### Configurar GitHub Actions

1. No repositório GitHub, adicione os seguintes **secrets**:
   - `DOCKER_USERNAME`: Nome de usuário do Docker Hub.
   - `DOCKER_PASSWORD`: Senha do Docker Hub.
   - `SSH_PRIVATE_KEY`: Chave privada SSH para acessar a VM.
   - `VM_IP`: Endereço IP da sua VM.

2. Crie um workflow no GitHub Actions usando o arquivo `deploy.yml` fornecido no diretório `.github/workflows/`.

## Deploy da Aplicação

### Configuração do Workflow GitHub Actions

Certifique-se de que o arquivo `deploy.yml` está localizado em `.github/workflows/` e contém a configuração correta para o build e deploy.

### Passos de Deploy

1. **Push para o Branch Principal**:
   - Quando você faz um push para o branch `main`, o workflow do GitHub Actions será acionado.
   - O workflow irá:
     - Fazer checkout do código.
     - Construir a aplicação com Maven.
     - Construir e enviar a imagem Docker para o Docker Hub.
     - Fazer SSH para a VM Azure e atualizar o contêiner Docker.

## Testes da API

### Endpoints CRUD

Aqui estão exemplos de requisições para testar os endpoints CRUD da API:

- **Criar Recurso**:
  ```http
  POST http://localhost:8080/api/resources
  Content-Type: application/json

  {
    "name": "Sample Resource",
    "description": "This is a sample resource."
  }
  ```

- **Ler Recurso**:
  ```http
  GET http://localhost:8080/api/resources/{id}
  ```

- **Atualizar Recurso**:
  ```http
  PUT http://localhost:8080/api/resources/{id}
  Content-Type: application/json

  {
    "name": "Updated Resource",
    "description": "This is an updated resource."
  }
  ```

- **Excluir Recurso**:
  ```http
  DELETE http://localhost:8080/api/resources/{id}
  ```

## Scripts JSON CRUD

- **Criar**: `create_resource.json`
- **Ler**: `read_resource.json`
- **Atualizar**: `update_resource.json`
- **Excluir**: `delete_resource.json`

## Equipe de Desenvolvimento

- **Francineldo Luan Martins Alvelino** -> RM: 99558 -> Responsabilidades: Backend para operações relacionadas ao 'Carrinhos'.
- **Daniel dos Santos Araujo Faria** -> RM: 99067 -> Responsabilidades: Backend para operações relacionadas ao 'Cliente' e 'Pedido'.
- **Enzo Lafer Gallucci** -> RM: 551111 -> Responsabilidades: Backend para operações relacionadas a 'Remédio'.
- **Ramon Cezarino Lopez** -> RM: 551279 -> Responsabilidades: Revisão de código.
- **Arthur Mitsuo Yamamoto** -> RM: 551283 -> Responsabilidades: Documentação e gerenciamento de projetos.

## Cronograma de Desenvolvimento

**Semana 1:**
- **Francineldo**: Implementação de 'Carrinhos'.
- **Daniel**: Implementação de 'Cliente' e 'Pedido'.
- **Enzo**: Implementação de 'Remédio'.

**Semana 2:**
- **Francineldo**: Testes e correções no carrinho.
- **Daniel**: Testes e correções no cliente e no pedido.
- **Enzo**: Testes e correções no remédio.

**Semana 3:**
- **Ramon e Arthur**: Revisão de código.
- **Arthur**: Preparação da documentação técnica e do cronograma.

## Instrução de como Rodar a Aplicação

1. Clone o repositório: https://github.com/ArthurMitsuoYamamoto/PharmaEaseTotem.git.
2. Abra o repositório no IntelliJ IDEA.
3. No IntelliJ IDEA, selecione "Obter do Controle de Versão" e insira o URL do GitHub.
4. O IntelliJ IDEA baixará automaticamente as dependências e construirá o projeto.

## Link do Vídeo

[Vídeo de Configuração e Deploy](https://www.youtube.com/watch?v=Wf4Wggnx59g)

## Público-Alvo

O público-alvo são clientes de farmácias que buscam conveniência, recomendações de medicamentos e uma experiência tecnologicamente avançada usando IA através de um totem farmacêutico de autoatendimento.

## Problemas que a Aplicação se Propõe a Solucionar

- **Fila e Tempo de Espera Longos**: Reduz o tempo de espera ao automatizar o processo de compra.
- **Falta de Personalização nas Recomendações**: Oferece sugestões personalizadas baseadas em histórico e sintomas.
- **Dificuldade em Encontrar Medicamentos Específicos**: Informa a localização dos medicamentos nas prateleiras.
- **Ineficiência no Atendimento no Balcão**: Fornece informações antecipadas para otimizar o atendimento.
- **Falta de Feedback dos Clientes**: Coleta feedback sobre eficácia dos medicamentos e satisfação.

## Evol

ução em Comparação à Entrega da Sprint Anterior

1. **Documentação**: Adicionada documentação online (Swagger-UI).
2. **Conexão com Banco de Dados**: Implementação com SQL Azure.
3. **Código**: Aprimoramento geral e remoção de classes desnecessárias.

## Diagrama

[Link para baixar imagem do diagrama](https://www.mediafire.com/view/v01bx70h6qxbdy5/Imagem_do_WhatsApp_de_2024-09-14_%25C3%25A0%2528s%2529_18.58.02_156e96f2.jpg/file)

## Licença

Este projeto está licenciado sob a [Licença MIT](LICENSE).

## Contato

Para mais informações, entre em contato com [Arthur Mitsuo Yamamoto](arthuryamamoto0@gmail.com).

---

### *Observações*

- *Substitua* yourusername/pharmaease-totem pelo URL do seu repositório GitHub.
- *Substitua* seu.email@example.com pelo seu e-mail para contato.
- *Scripts JSON*: Adicione os arquivos de script JSON na raiz do repositório e forneça seus conteúdos conforme necessário.
