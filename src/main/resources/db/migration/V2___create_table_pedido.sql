CREATE TABLE tb_pedido (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    codigo BIGINT,
    nome VARCHAR(255) NOT NULL,
    telefone VARCHAR(20),
    data_pedido DATE NOT NULL,
    realizado_pagamento BOOLEAN NOT NULL,
    email VARCHAR(255),
    cpf VARCHAR(14) UNIQUE,
    data_retirada DATE,
    qrcode VARCHAR(255),
    desconto NUMERIC(10,2) DEFAULT 0,
    preco_total NUMERIC(19,2) NOT NULL,
    preco_total_desconto NUMERIC(19,2)
);
