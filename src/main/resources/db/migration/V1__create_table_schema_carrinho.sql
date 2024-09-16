-- Tabela de Carrinhos
CREATE TABLE Carrinho (
                          id BIGINT IDENTITY(1,1) PRIMARY KEY,
                          precoTotal DECIMAL(10, 2) NOT NULL,
                          cliente_cpf BIGINT,
                          FOREIGN KEY (cliente_cpf) REFERENCES Cliente(id)
);

-- Tabela de Clientes
CREATE TABLE Cliente (
                         id BIGINT IDENTITY(1,1) PRIMARY KEY,
                         nome NVARCHAR(255) NOT NULL,
                         email NVARCHAR(255) NOT NULL
);

-- Tabela de Pedidos
CREATE TABLE Pedido (
                        pedido_id BIGINT IDENTITY(1,1) PRIMARY KEY,
                        quantidade INT NOT NULL,
                        preco DECIMAL(10, 2) NOT NULL,
                        carrinho_id BIGINT,
                        remedio_id BIGINT,
                        FOREIGN KEY (carrinho_id) REFERENCES Carrinho(id),
                        FOREIGN KEY (remedio_id) REFERENCES Remedio(id)
);


-- Tabela de Remédios
CREATE TABLE Remedio (
                         id BIGINT IDENTITY(1,1) PRIMARY KEY,
                         nome NVARCHAR(255) NOT NULL,
                         preco DECIMAL(10, 2) NOT NULL,
                         quantidade INT NOT NULL,
                         controlado BIT NOT NULL
);











