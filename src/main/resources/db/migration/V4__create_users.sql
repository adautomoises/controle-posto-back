CREATE TABLE IF NOT EXISTS users (
    id BIGSERIAL PRIMARY KEY,
    login VARCHAR NOT NULL UNIQUE,
    password VARCHAR NOT NULL,
    role VARCHAR NOT NULL
);