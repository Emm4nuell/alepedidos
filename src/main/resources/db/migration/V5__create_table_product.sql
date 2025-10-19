CREATE TABLE tb_product(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(100) NOT NULL,
    description VARCHAR(255) NOT NULL,
    flavor VARCHAR(100) NOT NULL,
    size VARCHAR(100) NOT NULL,
    status BOOLEAN NOT NULL DEFAULT true,
    id_category UUID NOT NULL,
    CONSTRAINT fk_product_category FOREIGN KEY (id_category) REFERENCES tb_category(id) ON DELETE CASCADE
)