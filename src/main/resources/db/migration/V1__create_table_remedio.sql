-- Tabela de Remédios
CREATE TABLE Remedio (
                         id BIGINT IDENTITY(1,1) PRIMARY KEY,
                         nome NVARCHAR(255) NOT NULL,
                         preco DECIMAL(10, 2) NOT NULL,
                         quantidade INT NOT NULL,
                         controlado BIT NOT NULL
);

