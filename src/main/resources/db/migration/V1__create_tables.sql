CREATE TYPE tipo_combustivel AS ENUM ('Gasolina', 'Diesel');

CREATE TABLE IF NOT EXISTS combustivel (
    id BIGSERIAL PRIMARY KEY,
    tipo tipo_combustivel NOT NULL,
    valor NUMERIC NOT NULL
);

CREATE TABLE IF NOT EXISTS tanque (
    id BIGSERIAL PRIMARY KEY,
    capacidade NUMERIC NOT NULL,
    combustivel_id BIGSERIAL NOT NULL,
    CONSTRAINT fk_combustivel_id FOREIGN KEY (combustivel_id) REFERENCES combustivel(id)
);

CREATE TABLE IF NOT EXISTS bomba (
    id BIGSERIAL PRIMARY KEY,
    tanque_id BIGSERIAL NOT NULL,
    CONSTRAINT fk_tanque_id FOREIGN KEY (tanque_id) REFERENCES tanque(id)
);

CREATE TABLE IF NOT EXISTS abastecimento (
    id BIGSERIAL PRIMARY KEY,
    bomba_id BIGSERIAL NOT NULL,
    CONSTRAINT fk_bomba_id FOREIGN KEY (bomba_id) REFERENCES bomba(id),
    valor NUMERIC NOT NULL,
    imposto NUMERIC NOT NULL,
    litros NUMERIC NOT NULL,
    data date NOT NULL
);