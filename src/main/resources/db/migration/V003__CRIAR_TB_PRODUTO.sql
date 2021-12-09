CREATE TABLE TB_PRODUTO
(
    ID         BIGSERIAL PRIMARY KEY,
    FOTO       BYTEA,
    PRECO      NUMERIC(19, 2),
    QUANTIDADE INT,
    DESCRICAO  VARCHAR(255),
    ESTOQUE_ID INT NOT NULL,
    TIPO_ID    INT NOT NULL,
    CONSTRAINT TB_ESTOQUE_ID_PRODUTO_ID
        FOREIGN KEY (ESTOQUE_ID)
            REFERENCES TB_ESTOQUE (ID),
    CONSTRAINT TB_TIPO_ID_PRODUTO_ID
        FOREIGN KEY (TIPO_ID)
            REFERENCES TB_TIPO_PRODUTO (ID)

)