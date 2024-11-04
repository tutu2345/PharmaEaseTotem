# PharmaEaseTotem-API
API do projeto PharmaEaseTotem - Facilitando o Acesso a Medicamentos

# Equipe de Desenvolvimento:
Arthur - IA, Mobile, DevOps
Daniel - .NET
Enzo - Banco de dados
Francis - QA, Devops
Ramon - Java

**Cronograma de Desenvolvimento - PharmaEaseTotem**
---

**1. Definição das Atividades e Responsabilidades:**

- **Francis**:
    - Desenvolvimento dos forms.
- **Daniel dos Santos Araujo Faria**:
    - Desenvolvimento do backend para operações relacionadas ao DTO'.
- **Enzo Lafer Gallucci**:
    - Ajustes nos services e adição ni TimeLeaf.
- **Ramon Cezarino Lopez**:
    - Revisão de código.
- **Arthur Mitsuo Yamamoto**:
    - Documentação e gerenciamento de projetos.


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


POST http://localhost:8080/clientes
Content-Type: application/json

{
"nome": "Nome do Cliente",
"email": "cliente@email.com"
}

  ```
  GET http://localhost:8080/clientes/{id}
  ```

- **Atualizar Recurso**:
  ```http
  PUT http://localhost:8080/clientes/{id}
Content-Type: application/json

{
"nome": "Nome Atualizado",
"email": "clienteatualizado@email.com"
}

- **deletar recurso**:
 ```
http://localhost:8080/clientes/deletar/{id}
  ```

## Scripts JSON CRUD

- **Criar**: `create_resource.json`
- **Ler**: `read_resource.json`
- **Atualizar**: `update_resource.json`
- **Excluir**: `delete_resource.json`


## Cronograma de Desenvolvimento

**Semana 1:**
- **Francis**:
    - Implementação da funcionalidade de autenticação com Spring Security, incluindo a gestão de perfis de segurança, controlando o acesso às diferentes áreas do sistema.'.
- **Daniel**:
    - Criação de DTOs para a gestão de usuários e adaptação das regras de segurança, garantindo que apenas usuários autorizados possam realizar ações específicas.
      '.
- **Enzo**:
    - Implementação de recursos de internacionalização, permitindo que o aplicativo se adapte a diferentes idiomas e regiões, melhorando a acessibilidade para usuários de diversas localidades.

**Semana 2:**
- **Francis**:
    - Configuração de recursos de mensageria utilizando RabbitMQ, criando produtores e consumidores para comunicação assíncrona entre os serviços, aprimorando a escalabilidade e eficiência do sistema.
- **Daniel**:
    - Testes e validações na implementação da autenticação e nas regras de segurança, assegurando que as permissões funcionem corretamente.
- **Enzo**:
    - Testes de funcionalidade para os recursos de internacionalização, garantindo que todas as strings fossem traduzidas corretamente.

**Semana 3:**
- **Ramon e Arthur Mitsuo Yamamoto**:
    - Revisão de código das novas implementações de segurança, internacionalização e mensageria, garantindo a conformidade com as melhores práticas.
- **Arthur Mitsuo Yamamoto**:
    - Integração do Spring Boot Actuator para monitoramento do aplicativo, além de preparação da documentação técnica e do cronograma, incluindo as novas funcionalidades de monitoramento e inteligência artificial.

---

## Instrução de como rodar a aplicação
1. Clonar o Repositório
   Primeiro, clone o repositório em sua máquina local:
   git clone https://github.com/RamonReserva/PharmaEaseTotem.git
2. Abrir o Projeto no IntelliJ IDEA
   Abra o IntelliJ IDEA.

No menu inicial, selecione a opção "Obter do Controle de Versão" (ou "Get from Version Control").

Insira o link do repositório GitHub no campo URL:https://github.com/RamonReserva/PharmaEaseTotem.git
Clique em Clone para baixar o projeto.

O IntelliJ IDEA irá automaticamente detectar as ferramentas de construção (como Maven) e baixar as dependências necessárias.

3. Configuração do Maven
   Ao abrir o projeto, o Maven será configurado automaticamente. Certifique-se de que as dependências foram baixadas corretamente.

Se necessário, você pode rodar o seguinte comando no terminal do IntelliJ para garantir que todas as dependências estão instaladas:
mvn clean install
4. Rodar a Aplicação
   A classe principal do projeto é TotemApiApplication. Para rodar o projeto:

No painel de navegação do IntelliJ IDEA, localize a classe TotemApiApplication dentro do pacote:


src/main/java/br/com/pharmeeasetotem/totemapi/TotemApiApplication.java
Clique com o botão direito sobre a classe e selecione Run 'TotemApiApplication' para iniciar a aplicação.

5. Acessar a Aplicação
   Com a aplicação em execução, você pode acessar a API localmente através do seguinte endereço:

http://localhost:8080

6. para logar:

username: user

   password: password






## Público-Alvo:
O público-alvo são clientes de farmácias que buscam conveniência, recomendações de medicamentos e uma experiência tecnologicamente avançada usando IA através de um totem farmacêutico de autoatendimento.

## Problemas que a aplicação se propõe a solucionar:

A proposta de um totem farmacêutico de autoatendimento visa abordar várias questões comuns encontradas em farmácias tradicionais, melhorando a experiência do cliente e otimizando o processo de compra de medicamentos.

A seguir, são detalhados os principais problemas que esta solução pretende solucionar:

**Fila e Tempo de Espera Longos:**

Problema: Clientes frequentemente enfrentam filas longas e tempos de espera elevados para obter atendimento nas farmácias.

Solução: O totem automatiza parte do processo de compra, permitindo que os clientes selecionem medicamentos e recebam sugestões personalizadas antes de chegarem ao balcão, reduzindo significativamente o tempo de espera.
Falta de Personalização nas Recomendações:

Problema: As recomendações de medicamentos são geralmente baseadas em interações rápidas e sem um histórico detalhado do cliente, o que pode resultar em sugestões genéricas.

Solução: Utilizando inteligência artificial, o totem oferece sugestões de medicamentos baseadas nas compras anteriores do cliente e nos sintomas informados, proporcionando uma experiência mais personalizada e assertiva.
Dificuldade em Encontrar Medicamentos Específicos:

Problema: Clientes muitas vezes têm dificuldade em localizar medicamentos específicos nas prateleiras, necessitando da ajuda de um atendente.

Solução: O totem informa diretamente ao cliente onde encontrar os medicamentos desejados nas prateleiras, facilitando o processo de compra sem a necessidade de intervenção de um atendente.
Ineficiência no Atendimento no Balcão:

Problema: O processo de atendimento no balcão pode ser lento, especialmente quando os atendentes precisam iniciar o processo de assistência do zero.

Solução: O totem gera uma senha para o recepcionista do balcão e envia as informações selecionadas pelo usuário para uma dashboard, permitindo que o atendente já saiba os medicamentos escolhidos pelo cliente antes mesmo de atendê-lo, otimizando a eficiência do atendimento.
Falta de Feedback dos Clientes:

Problema: Farmácias muitas vezes não coletam feedback suficiente sobre a eficácia dos medicamentos e a satisfação dos clientes.

Solução: Após a compra, o totem solicita ao cliente que informe o sintoma tratado e avalie a satisfação com o produto de 0 a 5 estrelas. Este feedback é coletado antes da geração da senha para retirada do medicamento no balcão, proporcionando dados valiosos para a farmácia melhorar seus serviços e produtos

### Evolução em comparação a entrega da Sprint anterior:
1-Implementação do Thymeleaf: Ajudei a configurar e implementar o Thymeleaf para renderizar formulários HTML, criar listagens de clientes e estruturar a interação entre o back-end e o front-end. Fizemos isso para integrar as funcionalidades de CRUD com templates HTML.

2-Refatoração do Controller com DTOs: Refatoramos o ClienteController para utilizar DTOs (Data Transfer Objects), otimizando a comunicação entre o front-end e o back-end. Isso melhorou a separação de responsabilidades e tornou o código mais limpo e organizado.

3-Criação de Instruções para Deploy com Docker: Trabalhamos juntos na configuração do Docker e criamos um fluxo de deploy usando o Docker, além de resolver problemas no GitHub Actions. Com isso, estabelecemos um caminho mais claro para rodar o projeto tanto localmente quanto em um container.


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

## Evolução em Comparação à Entrega da Sprint Anterior

1- Funcionalidades de Autenticação com Spring Security: Implementamos a autenticação de usuários utilizando o Spring Security, incluindo a gestão de perfis de segurança. Essa funcionalidade permite controlar o acesso às diferentes áreas do sistema, assegurando que apenas usuários autorizados possam realizar ações específicas.

2- Implementação de Recursos de Internacionalização: Adicionamos suporte à internacionalização, permitindo que o aplicativo se adapte a diferentes idiomas e regiões. Essa implementação melhora a acessibilidade do sistema para usuários de diversas localidades.

3- Configuração de Recursos de Mensageria: Estabelecemos a configuração de mensageria utilizando RabbitMQ, criando produtores e consumidores para comunicação assíncrona entre os serviços. Isso aprimora a escalabilidade e a eficiência do sistema ao lidar com tarefas que não precisam ser executadas imediatamente.

4- Monitoramento com Spring Boot Actuator: Integramos o Spring Boot Actuator para monitoramento do aplicativo, permitindo acompanhar o estado da aplicação, métricas de desempenho e informações de saúde em tempo real. Isso facilita a detecção de problemas e a manutenção do sistema.

5- Recursos de Inteligência Artificial com Spring AI: Implementamos funcionalidades de inteligência artificial utilizando o framework Spring AI. Essa nova camada de funcionalidade permitirá ao sistema oferecer recomendações e análises preditivas, aumentando a interatividade e a eficiência das operações.


## Diagrama

[Link para baixar imagem do diagrama](https://www.mediafire.com/view/v01bx70h6qxbdy5/Imagem_do_WhatsApp_de_2024-09-14_%25C3%25A0%2528s%2529_18.58.02_156e96f2.jpg/file)

## Licença

Este projeto está licenciado sob a [Licença MIT](LICENSE).

## Contato

Para mais informações, entre em contato com [Arthur Mitsuo Yamamoto](arthuryamamoto0@gmail.com).