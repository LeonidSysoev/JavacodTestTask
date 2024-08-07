-- liquibase formatted sql

--changeset LeonidS1:1
CREATE TABLE wallet(
    wallet_id UUID PRIMARY KEY,
    amouth decimal
)


