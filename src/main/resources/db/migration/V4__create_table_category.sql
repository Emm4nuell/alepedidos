CREATE TABLE tb_category(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    category VARCHAR(50) NOT NULL,
    description VARCHAR(200))