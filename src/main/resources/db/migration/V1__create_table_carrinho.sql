-- Tabela de Carrinhos
CREATE TABLE Carrinho (
                          id BIGINT IDENTITY(1,1) PRIMARY KEY,
                          precoTotal DECIMAL(10, 2) NOT NULL,
                          cliente_cpf BIGINT,
                          FOREIGN KEY (cliente_cpf) REFERENCES Cliente(id)
);



