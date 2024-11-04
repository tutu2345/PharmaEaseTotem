-- Exemplo de criação de tabela
CREATE TABLE usuarios (
    id INT PRIMARY KEY,
    nome VARCHAR(100),
    email VARCHAR(100),
    senha VARCHAR(100)
);

-- Exemplo de inserção de dados
INSERT INTO usuarios (id, nome, email, senha) VALUES
(1, 'Arthur', 'arthur@email.com', 'senha123'),
(2, 'Maria', 'maria@email.com', 'senha456');
