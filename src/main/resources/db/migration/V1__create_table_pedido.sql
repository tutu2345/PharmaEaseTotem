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





