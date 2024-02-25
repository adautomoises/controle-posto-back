INSERT INTO combustivel (id, tipo, valor) VALUES (1, 'Gasolina', 5.58), (2, 'Alcool', 2.49), (3, 'Diesel', 1.0635), (4, 'Gas_Natural', 1.603);
INSERT INTO tanque (id, capacidade) VALUES (1, 1000), (2, 2000);
INSERT INTO bomba (id, combustivel_id, tanque_id) VALUES (1, 1, 1), (2, 1, 1), (3, 3, 2), (4, 3, 2);