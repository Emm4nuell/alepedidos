CREATE TABLE tb_scheduling_product(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    quantity INTEGER,
    size NUMERIC(10, 2),
    id_scheduling UUID NOT NULL,
    id_product UUID NOT NULL,
    CONSTRAINT fk_scheduling_product_scheduling FOREIGN KEY (id_scheduling) REFERENCES tb_scheduling(id),
    CONSTRAINT fk_scheduling_product_product FOREIGN KEY (id_product) REFERENCES tb_product(id)
)