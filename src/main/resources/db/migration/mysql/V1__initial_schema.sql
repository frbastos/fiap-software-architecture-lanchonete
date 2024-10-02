CREATE TABLE IF NOT EXISTS `product` (
    id BIGINT AUTO_INCREMENT,
    description VARCHAR(255) NOT NULL,
    price DECIMAL(19,2) NOT NULL,
    category VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`)
);

ALTER TABLE product AUTO_INCREMENT = 1000;

CREATE TABLE IF NOT EXISTS `customer` (
    id BIGINT AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    document VARCHAR(255) NOT NULL,
    mail VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`)
);

ALTER TABLE customer AUTO_INCREMENT = 1000;

CREATE TABLE IF NOT EXISTS `payment` (
    id BIGINT AUTO_INCREMENT,
    time TIMESTAMP NOT NULL,
    amount DECIMAL(19,2) NOT NULL,
    transaction_id VARCHAR(255) NOT NULL,
    status VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`)
);

ALTER TABLE payment AUTO_INCREMENT = 1000;

CREATE TABLE IF NOT EXISTS `orders` (
    id BIGINT AUTO_INCREMENT,
    customer_id BIGINT DEFAULT NULL,
    state VARCHAR(255) NOT NULl,
    total_price DECIMAL(19,2) NOT NULL,
    payment_confirmation_status VARCHAR(255) NOT NULL,
    payment_id BIGINT DEFAULT NULL,
    creation_time TIMESTAMP NOT NULL,
    order_number DECIMAL(19,1) NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customer(id),
    FOREIGN KEY (payment_id) REFERENCES payment(id),
    PRIMARY KEY (`id`)
);

ALTER TABLE orders AUTO_INCREMENT = 1000;

CREATE TABLE IF NOT EXISTS `order_item` (
    id BIGINT AUTO_INCREMENT,
    product_id BIGINT NOT NULL,
    unit_price DECIMAL(19,2) NOT NULL,
    quantity INT NOT NULL,
    observation TEXT DEFAULT NULL,
    total_price DECIMAL(19,2) NOT NULL,
    order_id BIGINT NOT NULL,
    FOREIGN KEY (product_id) REFERENCES product (id),
    FOREIGN KEY (order_id) REFERENCES `orders` (id),
    PRIMARY KEY (`id`)
);

ALTER TABLE order_item AUTO_INCREMENT = 1000;