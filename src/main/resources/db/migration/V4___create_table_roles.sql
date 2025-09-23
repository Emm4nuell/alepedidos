CREATE TABLE tb_role(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    role VARCHAR(20) NOT NULL,
    id_user UUID NOT NULL,
    CONSTRAINT fk_role_user FOREIGN KEY (id_user) REFERENCES tb_user(id) ON DELETE CASCADE
)