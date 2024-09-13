CREATE TABLE IF NOT EXISTS `product` (
    id VARCHAR(36) PRIMARY KEY,
    description VARCHAR(255) NOT NULL,
    price DECIMAL(19,2) NOT NULL,
    category VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS `customer` (
    id VARCHAR(36) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    document VARCHAR(255) NOT NULL,
    mail VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS `payment` (
    id VARCHAR(36) PRIMARY KEY,
    time TIMESTAMP NOT NULL,
    amount DECIMAL(19,2) NOT NULL,
    transaction_id VARCHAR(255) NOT NULL,
    status VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS `orders` (
    id VARCHAR(36) PRIMARY KEY,
    customer_id VARCHAR(36) DEFAULT NULL,
    state VARCHAR(255) NOT NULl,
    total_price DECIMAL(19,2) NOT NULL,
    payment_confirmation_status VARCHAR(255) NOT NULL,
    payment_id VARCHAR(36) DEFAULT NULL,
    FOREIGN KEY (customer_id) REFERENCES customer(id),
    FOREIGN KEY (payment_id) REFERENCES payment(id)
);

CREATE TABLE IF NOT EXISTS `order_item` (
    id VARCHAR(36) PRIMARY KEY,
    product_id VARCHAR(36) NOT NULL,
    unit_price DECIMAL(19,2) NOT NULL,
    quantity INT NOT NULL,
    observation TEXT DEFAULT NULL,
    total_price DECIMAL(19,2) NOT NULL,
    order_id VARCHAR(36) NOT NULL,
    FOREIGN KEY (product_id) REFERENCES product (id),
    FOREIGN KEY (order_id) REFERENCES `orders` (id)
);