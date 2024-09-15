# PharmaEaseTotem-API
API do projeto PharmaEaseTotem - Facilitando o Acesso a Medicamentos

# Equipe de Desenvolvimento:
- **Francineldo Luan Martins Alvelino** -> RM: 99558 -> Responsabilidades: Backend para revisar e arrumar oroblemas'.
- **Daniel dos Santos Araujo Faria** -> RM: 99067 -> Responsabilidades: Backend para adição de novas layers como o forms'.
- **Enzo Lafer Gallucci** -> RM: 551111 -> Responsabilidades: Backend para configuração de classes'.
- **Ramon Cezarino Lopez** -> RM: 551279 -> Responsabilidades: Revisão de código.
- **Arthur Mitsuo Yamamoto** -> RM: 551283 -> Responsabilidades: Documentação e gerenciamento de projetos.

**Cronograma de Desenvolvimento - PharmaEaseTotem**
---

**Semana 1:**
- **Francineldo**: Mudanças nas classes existentes'.
- **Daniel**: Adicionou as novas dependências'.
- **Enzo**: Configurou o clienteService'.
  
- **Semana 2:**
- **Francineldo**: Testes e correções no carrinho.
- **Daniel**: Adicionou os forms.
- **Enzo**: Configurou o DTO.
  
- **Semana 3:**
- **Ramon e Arthur**: Revisão de código.
- **Arthur**: Preparação da documentação técnica e do cronograma.

---



## Instrução de como rodar a aplicação
1. Clone o repositório: https://github.com/ArthurMitsuoYamamoto/PharmaEaseTotem.git.
1. Clone o repositório: https://github.com/RamonReserva/PharmaEaseTotem.git
2. Abra o repositório no IntelliJ IDEA.
3. No IntelliJ IDEA, selecione "Obter do Controle de Versão" e insira o URL do GitHub.
4. O IntelliJ IDEA baixará automaticamente as dependências e construirá o projeto.


## Link do vídeo:
https://www.youtube.com/watch?v=Wf4Wggnx59g


## Público-Alvo:
O público-alvo são clientes de farmácias que buscam conveniência, recomendações de medicamentos e uma experiência tecnologicamente avançada usando API e IA através de um totem de autoatendimento
## Problemas que a aplicação se propõe a solucionar:

- **Fila e Tempo de Espera Longos**: Reduz o tempo de espera ao automatizar o processo de compra.
- **Falta de Personalização nas Recomendações**: Oferece sugestões personalizadas baseadas em histórico e sintomas.
- **Dificuldade em Encontrar Medicamentos Específicos**: Informa a localização dos medicamentos nas prateleiras.
- **Ineficiência no Atendimento no Balcão**: Fornece informações antecipadas para otimizar o atendimento.
- **Falta de Feedback dos Clientes**: Coleta feedback sobre eficácia dos medicamentos e satisfação.

### Evolução em comparação a entrega da Sprint anterior:
1. **Documentação**: Adicionada documentação online (Swagger-UI).
2. **Conexão com Banco de Dados**: Implementação com SQL Azure.
3. **Código**: Aprimoramento geral e remoção de classes desnecessárias.


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
- **Criar Novo Cliente**:
  ```http
  POST http://localhost:8080/clientes
  Content-Type: application/json
  {
    "nome": "Nome do Cliente",
    "email": "email@exemplo.com"
  }
GET http://localhost:8080/clientes/{id}


- **AtualizarCliente**;
- ```http
PUT http://localhost:8080/clientes/{id}
Content-Type: application/json
{
"nome": "Nome Atualizado",
"email": "email@atualizado.com"
}

- **Excluircliente**;
- DELETE http://localhost:8080/clientes/{id}



  ```

  ```
## Scripts JSON CRUD

### Diagrama:

link para baixar imagem do diagrama:
https://www.mediafire.com/view/v01bx70h6qxbdy5/Imagem_do_WhatsApp_de_2024-09-14_%25C3%25A0%2528s%2529_18.58.02_156e96f2.jpg/file

Este projeto está licenciado sob a [Licença MIT](LICENSE).
Para mais informações, entre em contato com [Arthur Mitsuo Yamamoto](arthuryamamoto0@gmail.com)

