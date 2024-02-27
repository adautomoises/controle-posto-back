INSERT INTO combustivel (id, tipo, valor) VALUES (1, 'Gasolina', 5.90), (2, 'Diesel', 4.52);
INSERT INTO tanque (id, capacidade, combustivel_id) VALUES (1, 1000, 1), (2, 2000, 2);
INSERT INTO bomba (id, tanque_id) VALUES (1, 1), (2, 1), (3, 2), (4, 2);