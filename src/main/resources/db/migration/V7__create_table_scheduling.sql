CREATE TABLE tb_scheduling(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    status BOOLEAN DEFAULT true,
    date_withdrawn DATE,
    payment VARCHAR(20) NOT NULL,
    id_user UUID NOT NULL,
    id_customer UUID NOT NULL,
    CONSTRAINT fk_scheduling_user FOREIGN KEY (id_user) REFERENCES tb_user(id) ON DELETE CASCADE,
    CONSTRAINT fk_scheduling_customer FOREIGN KEY (id_customer) REFERENCES tb_customer(id)
)