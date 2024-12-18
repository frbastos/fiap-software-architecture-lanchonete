-- Inserção de dados na tabela orders
INSERT INTO orders (customer_id, state, total_price, payment_confirmation_status, payment_id, creation_time, order_number)
VALUES (null, 'PENDING', 51.0, 'PENDING', null, '2024-09-15 09:30:00', 100000);

INSERT INTO orders (customer_id, state, total_price, payment_confirmation_status, payment_id, creation_time, order_number)
VALUES (1, 'PENDING', 67.0, 'PENDING', null, '2024-09-15 15:00:00', 200000);

-- Inserção de dados na tabela order_item
INSERT INTO order_item (product_id, unit_price, quantity, observation, total_price, order_id)
VALUES (1, 25.0, 1, null, 25.0, 1);

INSERT INTO order_item (product_id, unit_price, quantity, observation, total_price, order_id)
VALUES (4, 12.0, 1, null, 12.0, 1);

INSERT INTO order_item (product_id, unit_price, quantity, observation, total_price, order_id)
VALUES (7, 7.0, 1, null, 7.0, 1);

INSERT INTO order_item (product_id, unit_price, quantity, observation, total_price, order_id)
VALUES (10, 7.0, 1, null, 7.0, 1);

INSERT INTO order_item (product_id, unit_price, quantity, observation, total_price, order_id)
VALUES (2, 30.0, 2, null, 60.0, 2);

INSERT INTO order_item (product_id, unit_price, quantity, observation, total_price, order_id)
VALUES (7, 7.0, 1, null, 7.0, 2);