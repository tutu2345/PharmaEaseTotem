-- Adiciona a chave estrangeira na tabela Carrinho
ALTER TABLE Carrinho
    ADD CONSTRAINT FK_Carrinho_Cliente
        FOREIGN KEY (cliente_cpf) REFERENCES Cliente(id);

-- Adiciona a chave estrangeira na tabela Pedido para Carrinho
ALTER TABLE Pedido
    ADD CONSTRAINT FK_Pedido_Carrinho
        FOREIGN KEY (carrinho_id) REFERENCES Carrinho(id);

-- Adiciona a chave estrangeira na tabela Pedido para Remédio
ALTER TABLE Pedido
    ADD CONSTRAINT FK_Pedido_Remédio
        FOREIGN KEY (remedio_id) REFERENCES Remedio(id);
