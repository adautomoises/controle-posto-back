CREATE TYPE tipo_combustivel AS ENUM ('Gasolina', 'Alcool', 'Diesel', 'Gas_Natural');

CREATE TABLE IF NOT EXISTS combustivel (
    id BIGSERIAL PRIMARY KEY,
    tipo tipo_combustivel NOT NULL,
    valor NUMERIC NOT NULL
);

CREATE TABLE IF NOT EXISTS tanque (
    id BIGSERIAL PRIMARY KEY,
    capacidade NUMERIC NOT NULL
);

CREATE TABLE IF NOT EXISTS bomba (
    id BIGSERIAL PRIMARY KEY,
    combustivel_id BIGSERIAL NOT NULL,
    tanque_id BIGSERIAL NOT NULL,
    CONSTRAINT fk_combustivel_id FOREIGN KEY (combustivel_id) REFERENCES combustivel(id),
    CONSTRAINT fk_tanque_id FOREIGN KEY (tanque_id) REFERENCES tanque(id)
);

CREATE TABLE IF NOT EXISTS abastecimento (
    id BIGSERIAL PRIMARY KEY,
    tanque_id BIGSERIAL NOT NULL,
    CONSTRAINT fk_tanque_id FOREIGN KEY (tanque_id) REFERENCES tanque(id),
    valor NUMERIC NOT NULL,
    imposto NUMERIC NOT NULL,
    data date NOT NULL
);