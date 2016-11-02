CREATE SCHEMA IF NOT EXISTS bettysinventory;
USE bettysinventory;

CREATE TABLE IF NOT EXISTS bettysinventory.products (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  product_id VARCHAR(16) NOT NULL,
  product_name VARCHAR(16) NOT NULL,
  product_manufacturer VARCHAR(16) NOT NULL,
  product_price DECIMAL NOT NULL,
  PRIMARY KEY (id));
  
CREATE TABLE IF NOT EXISTS bettysinventory.product_images (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  product_id INT UNSIGNED NOT NULL,
  content_type VARCHAR(45) NOT NULL,
  image BLOB NOT NULL,
  PRIMARY KEY (id));
