CREATE SCHEMA IF NOT EXISTS robotsanddonuts;
USE robotsanddonuts;

CREATE TABLE IF NOT EXISTS robotsanddonuts.products (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  product_id VARCHAR(16) NOT NULL,
  product_name VARCHAR(16) NOT NULL,
  product_manufacturer VARCHAR(45) NOT NULL,
  product_price DECIMAL NOT NULL,
  PRIMARY KEY (id));
