CREATE TABLE establishment(
    id BIGINT PRIMARY KEY UNIQUE NOT NULL AUTO_INCREMENT,
    cnpj VARCHAR(100) NOT NULL,
    address VARCHAR(255) NOT NULL,
    phone VARCHAR(255) NOT NULL,
    moto_quantity VARCHAR(255) NOT NULL,
    cars_quantity VARCHAR(255) NOT NULL,
    moto_quantity_total VARCHAR(255) NOT NULL,
    cars_quantity_total VARCHAR(255) NOT NULL
);