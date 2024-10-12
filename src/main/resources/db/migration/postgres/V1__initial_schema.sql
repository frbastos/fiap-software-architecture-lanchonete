CREATE TABLE IF NOT EXISTS product (
    id BIGSERIAL,
    description VARCHAR(255) NOT NULL,
    price DECIMAL(19,2) NOT NULL,
    category VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS customer (
    id BIGSERIAL,
    name VARCHAR(255) NOT NULL,
    document VARCHAR(255) NOT NULL,
    mail VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS payment (
    id BIGSERIAL,
    time TIMESTAMP NOT NULL,
    amount DECIMAL(19,2) NOT NULL,
    transaction_id VARCHAR(255) NOT NULL,
    status VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS orders (
    id BIGSERIAL,
    customer_id BIGINT DEFAULT NULL,
    state VARCHAR(255) NOT NULL,
    total_price DECIMAL(19,2) NOT NULL,
    payment_confirmation_status VARCHAR(255) NOT NULL,
    payment_id BIGINT DEFAULT NULL,
    creation_time TIMESTAMP NOT NULL,
    order_number BIGINT NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customer(id),
    FOREIGN KEY (payment_id) REFERENCES payment(id),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS order_item (
    id BIGSERIAL,
    product_id BIGINT NOT NULL,
    unit_price DECIMAL(19,2) NOT NULL,
    quantity INT NOT NULL,
    observation TEXT DEFAULT NULL,
    total_price DECIMAL(19,2) NOT NULL,
    order_id BIGINT NOT NULL,
    FOREIGN KEY (product_id) REFERENCES product(id),
    FOREIGN KEY (order_id) REFERENCES orders(id),
    PRIMARY KEY (id)
);