INSERT INTO users (id, login, password, role) VALUES (1, 'admin', '$2a$10$1i7XWDTXr1XKt4aFjRdUIe3ctzipLgOzE2nCM58CJE8kmgLJJaXGq', 'MANAGER');

ALTER SEQUENCE users_id_seq RESTART WITH 2;