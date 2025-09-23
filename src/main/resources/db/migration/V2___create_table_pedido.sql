CREATE TABLE tb_order (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    code BIGINT,
    name VARCHAR(255) NOT NULL,
    phone VARCHAR(20),
    order_date DATE NOT NULL,
    payment_completed BOOLEAN NOT NULL,
    email VARCHAR(255),
    cpf VARCHAR(14) UNIQUE,
    pickup_date DATE,
    qr_code VARCHAR(255),
    discount NUMERIC(10,2) DEFAULT 0,
    total_price NUMERIC(19,2) NOT NULL,
    discounted_price NUMERIC(19,2),
    created_by_user VARCHAR(255),
    created_date TIMESTAMP,
    last_modified_by_user VARCHAR(255),
    last_modified_date TIMESTAMP
);
