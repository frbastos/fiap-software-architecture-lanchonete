INSERT INTO orders (id, customer_id, state, total_price, payment_confirmation_status, payment_id) VALUES ('bc0eccdb-f1f4-4766-84aa-b41fda366a7f', null, 'PENDING', 51.0, 'PENDING', null);
INSERT INTO orders (id, customer_id, state, total_price, payment_confirmation_status, payment_id) VALUES ('8d50fed2-3861-40fb-ba78-f0911d3730ec', '8834adb8-193e-4bed-a0b6-f1aba4735509', 'PENDING', 67.0, 'PENDING', null);

INSERT INTO order_item (id, product_id, unit_price, quantity, observation, total_price, order_id) VALUES ('dc31cbfa-f0d9-4d73-a882-bfe424473bdd', 'bc5bfa6d-7301-4e7a-9fd7-182112a28a9e', 25.0, 1, null, 25.0, 'bc0eccdb-f1f4-4766-84aa-b41fda366a7f');
INSERT INTO order_item (id, product_id, unit_price, quantity, observation, total_price, order_id) VALUES ('f89d27c5-d8de-413e-b454-d6032a0f5939', 'a030c851-c9ae-4e37-a576-67ed656c3123', 12.0, 1, null, 12.0, 'bc0eccdb-f1f4-4766-84aa-b41fda366a7f');
INSERT INTO order_item (id, product_id, unit_price, quantity, observation, total_price, order_id) VALUES ('5448462f-0048-4db0-a8f9-a505a119cfba', '0d827401-fa2e-4882-ab02-bf3d78e6bcdd', 7.0, 1, null, 7.0, 'bc0eccdb-f1f4-4766-84aa-b41fda366a7f');
INSERT INTO order_item (id, product_id, unit_price, quantity, observation, total_price, order_id) VALUES ('75ab1142-a6ba-43e4-9804-8b393de9be29', 'b45ffcf7-4b6e-49ae-876d-cfd2d9b98d21', 7.0, 1, null, 7.0, 'bc0eccdb-f1f4-4766-84aa-b41fda366a7f');

INSERT INTO order_item (id, product_id, unit_price, quantity, observation, total_price, order_id) VALUES ('500c1317-011a-4f1c-a359-f48da864f5a0', '885bf561-4c2e-408d-828e-cd90179d1a88', 30.0, 2, null, 60.0, '8d50fed2-3861-40fb-ba78-f0911d3730ec');
INSERT INTO order_item (id, product_id, unit_price, quantity, observation, total_price, order_id) VALUES ('d9997ffa-4f4e-4da3-bc77-2099e3bf500a', '1b081c36-015d-43f7-8bb9-6f6a6aa845e9', 7.0, 1, null, 7.0, '8d50fed2-3861-40fb-ba78-f0911d3730ec');

