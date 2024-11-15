CREATE TABLE orders
(
    id           UUID NOT NULL,
    order_number VARCHAR(255),
    scu_code     VARCHAR(255),
    price        DECIMAL,
    quantity     INTEGER,
    CONSTRAINT pk_orders PRIMARY KEY (id)
);