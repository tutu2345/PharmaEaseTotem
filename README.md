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

---

**2. Cronograma de Desenvolvimento:**

**Semana 1:**
- **Francis**:
    - Implementação dos Forms'.
- **Daniel**:
    - Implementação do DTO'.
- **Enzo**:
    - Mudanças no ClenteService e adição do TimeLeaf.

**Semana 2:**
- **Francis**:
    - Correção de problemas nos forms.
- **Daniel**:
    - Testes e correções no DTO'.
- **Enzo**:
    - .

**Semana 3:**
- **Ramon e Arthur Mitsuo Yamamoto**:
    - Revisão de código.
- **Arthur Mitsuo Yamamoto**:
    - Preparação da documentação técnica e do cronograma.

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



## Link do vídeo:
https://www.youtube.com/watch?v=Wf4Wggnx59g


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