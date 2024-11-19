ALTER TABLE products
    add column scu_code varchar(255),
    ADD CONSTRAINT uc_scu_code_products UNIQUE (scu_code);