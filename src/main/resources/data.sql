insert into bettysinventory.products (product_id, product_name, product_manufacturer, product_price) values ('10001', 'Olive Sheath Dress', 'ModCloth', 59.99);
insert into bettysinventory.products (product_id, product_name, product_manufacturer, product_price) values ('10002', 'Joys A-Line Dress', 'ModCloth', 99.99);
insert into bettysinventory.products (product_id, product_name, product_manufacturer, product_price) values ('10003', 'Ivory Tank Top', 'ModCloth', 39.99);
insert into bettysinventory.products (product_id, product_name, product_manufacturer, product_price) values ('10004', 'Photoshoot Sweater', 'ModCloth', 49.99);
insert into bettysinventory.products (product_id, product_name, product_manufacturer, product_price) values ('10005', 'Jeans Overalls', 'ModCloth', 79.99);
insert into bettysinventory.products (product_id, product_name, product_manufacturer, product_price) values ('10006', 'Knit Tunic', 'J Jill', 29.99);
insert into bettysinventory.products (product_id, product_name, product_manufacturer, product_price) values ('10007', 'Boatneck Tee', 'Ann Taylor', 24.99);
insert into bettysinventory.products (product_id, product_name, product_manufacturer, product_price) values ('10013', 'Dream Dress', 'Historical Clothing', 62.99);

insert into bettysinventory.customers (first_name, last_name, email, customer_since) values ('Steven', 'Richards', 'steve@littlecreekdesign.com', 1979);
insert into bettysinventory.customers (first_name, last_name, email, customer_since) values ('Lefty', 'Frizzell', 'lefty@yourdime.com', 1974);
insert into bettysinventory.customers (first_name, last_name, email, customer_since) values ('Tader', 'Tott', 'tader@youvegotthetader.com', 1989);
insert into bettysinventory.customers (first_name, last_name, email, customer_since) values ('Albert', 'Einstein', 'emc2@relativity.com', 1956);
insert into bettysinventory.customers (first_name, last_name, email, customer_since) values ('Pablo', 'Picasso', 'abstractart@impressions.com', 1961);

insert into bettysinventory.transactions (customer_id, product_id, transaction_date) values (1, 1, 'January 30, 2016');
insert into bettysinventory.transactions (customer_id, product_id, transaction_date) values (1, 4, 'January 30, 2016');
insert into bettysinventory.transactions (customer_id, product_id, transaction_date) values (1, 6, 'January 30, 2016');
insert into bettysinventory.transactions (customer_id, product_id, transaction_date) values (2, 1, 'March 3, 2016');
insert into bettysinventory.transactions (customer_id, product_id, transaction_date) values (3, 1, 'May 6, 2016');
insert into bettysinventory.transactions (customer_id, product_id, transaction_date) values (4, 1, 'November 8, 2016');
insert into bettysinventory.transactions (customer_id, product_id, transaction_date) values (4, 2, 'November 8, 2016');
insert into bettysinventory.transactions (customer_id, product_id, transaction_date) values (4, 3, 'November 8, 2016');
insert into bettysinventory.transactions (customer_id, product_id, transaction_date) values (4, 4, 'November 8, 2016');
insert into bettysinventory.transactions (customer_id, product_id, transaction_date) values (5, 1, 'August 14, 2016');