-- Criação da tabela products
CREATE TABLE IF NOT EXISTS product (
    id BIGSERIAL,
    description VARCHAR(255) NOT NULL,
    price DECIMAL(19,2) NOT NULL,
    category VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

-- Criação da tabela customer
CREATE TABLE IF NOT EXISTS customer (
    id BIGSERIAL,
    name VARCHAR(255) NOT NULL,
    document VARCHAR(255) NOT NULL,
    mail VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

-- Criação da tabela payment
CREATE TABLE IF NOT EXISTS payment (
    id BIGSERIAL,
    time TIMESTAMP NOT NULL,
    amount DECIMAL(19,2) NOT NULL,
    transaction_id VARCHAR(255) NOT NULL,
    status VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

-- Criação da tabela orders
CREATE TABLE IF NOT EXISTS orders (
    id BIGSERIAL,
    customer_id BIGINT,
    state VARCHAR(255) NOT NULL,
    total_price DECIMAL(19,2) NOT NULL,
    payment_confirmation_status VARCHAR(255) NOT NULL,
    payment_id BIGINT,
    creation_time TIMESTAMP NOT NULL,
    order_number DECIMAL(19,1) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (customer_id) REFERENCES customer(id),
    FOREIGN KEY (payment_id) REFERENCES payment(id)
);

-- Criação da tabela order_item
CREATE TABLE IF NOT EXISTS order_item (
    id BIGSERIAL,
    product_id BIGINT NOT NULL,
    unit_price DECIMAL(19,2) NOT NULL,
    quantity INT NOT NULL,
    observation TEXT DEFAULT NULL,
    total_price DECIMAL(19,2) NOT NULL,
    order_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (product_id) REFERENCES product(id),
    FOREIGN KEY (order_id) REFERENCES orders(id)
);