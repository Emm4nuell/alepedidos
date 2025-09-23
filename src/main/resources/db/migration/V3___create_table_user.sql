CREATE TABLE tb_user (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(100) NOT NULL,
    phone VARCHAR(11),
    email VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    cpf VARCHAR(11) UNIQUE,
    roles TEXT[],
    birth_date DATE
)