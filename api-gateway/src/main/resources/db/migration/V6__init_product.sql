CREATE TABLE products
(
    id           UUID NOT NULL PRIMARY KEY,
    name         VARCHAR(255),
    description  TEXT,
    price        DECIMAL
);