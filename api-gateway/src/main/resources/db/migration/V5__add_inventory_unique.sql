ALTER TABLE inventory
    ADD CONSTRAINT uc_scu_code UNIQUE (scu_code);