CREATE TABLE vehicles(
  id INT PRIMARY KEY UNIQUE NOT NULL AUTO_INCREMENT,
  brand VARCHAR(255) NOT NULL,
  model VARCHAR(255) NOT NULL,
  color VARCHAR(255) NOT NULL,
  plate VARCHAR(255) NOT NULL,
  type VARCHAR(255) NOT NULL,
);