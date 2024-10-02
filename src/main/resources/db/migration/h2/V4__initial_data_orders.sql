INSERT INTO orders (id, customer_id, state, total_price, payment_confirmation_status, payment_id, creation_time) VALUES (1, null, 'PENDING', 51.0, 'PENDING', null, '2024-09-15 09:30');
INSERT INTO orders (id, customer_id, state, total_price, payment_confirmation_status, payment_id, creation_time) VALUES (2, 1, 'PENDING', 67.0, 'PENDING', null, '2024-09-15 15:00');

INSERT INTO order_item (id, product_id, unit_price, quantity, observation, total_price, order_id) VALUES (1, 1, 25.0, 1, null, 25.0, 1);
INSERT INTO order_item (id, product_id, unit_price, quantity, observation, total_price, order_id) VALUES (2, 4, 12.0, 1, null, 12.0, 1);
INSERT INTO order_item (id, product_id, unit_price, quantity, observation, total_price, order_id) VALUES (3, 7, 7.0, 1, null, 7.0, 1);
INSERT INTO order_item (id, product_id, unit_price, quantity, observation, total_price, order_id) VALUES (4, 10, 7.0, 1, null, 7.0, 1);

INSERT INTO order_item (id, product_id, unit_price, quantity, observation, total_price, order_id) VALUES (5, 2, 30.0, 2, null, 60.0, 2);
INSERT INTO order_item (id, product_id, unit_price, quantity, observation, total_price, order_id) VALUES (6, 7, 7.0, 1, null, 7.0, 2);

