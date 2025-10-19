CREATE TABLE tb_customer(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(100) NOT NULL,
    phone VARCHAR(20),
    email VARCHAR(100) UNIQUE,
    cpf VARCHAR(11) UNIQUE,
    birth_date DATE
)