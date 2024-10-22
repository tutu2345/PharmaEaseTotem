-- Tabela de Clientes
CREATE TABLE Cliente (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         nome NVARCHAR(255) NOT NULL,
                         email NVARCHAR(255) NOT NULL
);


-- Tabela de Remédios
CREATE TABLE Remedio (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         nome NVARCHAR(255) NOT NULL,
                         preco DECIMAL(10, 2) NOT NULL,
                         quantidade INT NOT NULL,
                         controlado BIT NOT NULL
);



-- Tabela de Carrinhos
CREATE TABLE Carrinho (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          precoTotal DECIMAL(10, 2) NOT NULL,
                          cliente_cpf BIGINT,
                          FOREIGN KEY (cliente_cpf) REFERENCES Cliente(id)
);


-- Tabela de Pedidos
CREATE TABLE Pedido (
                        pedido_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        quantidade INT NOT NULL,
                        preco DECIMAL(10, 2) NOT NULL,
                        carrinho_id BIGINT,
                        remedio_id BIGINT,
                        FOREIGN KEY (carrinho_id) REFERENCES Carrinho(id),
                        FOREIGN KEY (remedio_id) REFERENCES Remedio(id)
);

-- Inserir clientes
INSERT INTO Cliente (nome, email) VALUES ('Ana Souza', 'ana.souza@example.com');
INSERT INTO Cliente (nome, email) VALUES ('Carlos Oliveira', 'carlos.oliveira@example.com');
INSERT INTO Cliente (nome, email) VALUES ('Maria Santos', 'maria.santos@example.com');

-- Inserir remédios
INSERT INTO Remedio (nome, preco, quantidade, controlado) VALUES ('Paracetamol', 12.50, 100, 0);
INSERT INTO Remedio (nome, preco, quantidade, controlado) VALUES ('Ibuprofeno', 25.00, 50, 0);
INSERT INTO Remedio (nome, preco, quantidade, controlado) VALUES ('Diazepam', 40.00, 30, 1);

-- Inserir carrinhos
-- O precoTotal é calculado com base nos pedidos inseridos depois
INSERT INTO Carrinho (precoTotal, cliente_cpf) VALUES (0.00, 1); -- Carrinho para Ana Souza
INSERT INTO Carrinho (precoTotal, cliente_cpf) VALUES (0.00, 2); -- Carrinho para Carlos Oliveira

-- Inserir pedidos
INSERT INTO Pedido (quantidade, preco, carrinho_id, remedio_id) VALUES (2, 12.50, 1, 1); -- 2 Paracetamol no carrinho 1
INSERT INTO Pedido (quantidade, preco, carrinho_id, remedio_id) VALUES (1, 40.00, 1, 3); -- 1 Diazepam no carrinho 1
INSERT INTO Pedido (quantidade, preco, carrinho_id, remedio_id) VALUES (1, 25.00, 2, 2); -- 1 Ibuprofeno no carrinho 2

-- Atualizar precoTotal dos carrinhos
UPDATE Carrinho SET precoTotal = (SELECT SUM(preco) FROM Pedido WHERE carrinho_id = 1) WHERE id = 1;
UPDATE Carrinho SET precoTotal = (SELECT SUM(preco) FROM Pedido WHERE carrinho_id = 2) WHERE id = 2;
