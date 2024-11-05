CREATE TABLE remedios (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT,
    preco DECIMAL(10, 2) NOT NULL,
    data_validade DATE NOT NULL,
    fabricante VARCHAR(255),
    quantidade_em_estoque INT DEFAULT 0
);
