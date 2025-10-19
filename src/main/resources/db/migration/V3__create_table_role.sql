CREATE TABLE tb_role(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    role varchar(50),
    user_id UUID NOT NULL,
    CONSTRAINT fk_role_user FOREIGN KEY (user_id) REFERENCES tb_user(id) ON DELETE CASCADE)