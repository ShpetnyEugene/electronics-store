-- Users
INSERT INTO USER (login, password, role) VALUES ('user', 'user', 2);
INSERT INTO USER (login, password, role) VALUES ('admin', 'admin', 1);
INSERT INTO USER (login, password, role) VALUES ('eugene', '123', 1);

-- Phones
INSERT INTO PRODUCT (name, amount, description, rating, images) VALUES ('Iphone-8', 100, 'Phone for rich', 0, 'http://localhost:8090/images/phone/iphone-8.jpeg');
INSERT INTO PRODUCT (name, amount, description, rating, images) VALUES ('Samsung-s8', 100, 'Phone for not rich', 0, 'http://localhost:8090/images/phone/samsung-s8.jpeg');
INSERT INTO PRODUCT (name, amount, description, rating, images) VALUES ('Xiaomi Mi-5', 100, 'Phone for 6yp1', 1, 'http://localhost:8090/images/phone/Xiaomi Mi-5.jpeg');

-- Laptops
INSERT INTO PRODUCT (name, amount, description, rating, images) VALUES ('Apple MacBook Air', 120, 'Laptops for rich', 2, 'http://localhost:8090/images/laptops/Apple MacBook Air.jpeg');
INSERT INTO PRODUCT (name, amount, description, rating, images) VALUES ('Lenova Legion', 110, 'Laptops for not rich', 4, 'http://localhost:8090/images/laptops/Lenovo Legion.jpeg');
INSERT INTO PRODUCT (name, amount, description, rating, images) VALUES ('ASUS Vivo Book', 100, 'Laptops for me', 7, 'http://localhost:8090/images/laptops/ASUS Vivo Book.jpeg');

-- Tablets
INSERT INTO PRODUCT (name, amount, description, rating, images) VALUES ('Ipad 4 Air', 100, 'Tablets for rich', 0, 'http://localhost:8090/images/tablets/Ipad.jpeg');
INSERT INTO PRODUCT (name, amount, description, rating, images) VALUES ('Samsung Galaxy Tab 8', 100, 'Tablets for not rich', 0, 'http://localhost:8090/images/tablets/Samsung Pad.jpeg');
INSERT INTO PRODUCT (name, amount, description, rating, images) VALUES ('Xiaomi Redmi 4 PRO+', 100, 'Tablets for me', 1, 'http://localhost:8090/images/tablets/Xiaomi Mi Pad.jpeg');

-- TVS
INSERT INTO PRODUCT (name, amount, description, rating, images) VALUES ('Samsung', 101, 'TV for rich', 0, 'http://localhost:8090/images/tvs/Samsung.jpeg');
INSERT INTO PRODUCT (name, amount, description, rating, images) VALUES ('LG', 103, 'TV for not rich', 0, 'http://localhost:8090/images/tvs/LG.jpeg');
INSERT INTO PRODUCT (name, amount, description, rating, images) VALUES ('Philips', 104, 'TV for me', 1, 'http://localhost:8090/images/tvs/Philips.jpeg');

-- PRODUCT-TYPE
INSERT INTO PRODUCT_TYPE (NAME, PRODUCT_ID) VALUES ('Phone', 1);
INSERT INTO PRODUCT_TYPE (NAME, PRODUCT_ID) VALUES ('Phone', 2);
INSERT INTO PRODUCT_TYPE (NAME, PRODUCT_ID) VALUES ('Phone', 3);

INSERT INTO PRODUCT_TYPE (NAME, PRODUCT_ID) VALUES ('Laptops', 4);
INSERT INTO PRODUCT_TYPE (NAME, PRODUCT_ID) VALUES ('Laptops', 5);
INSERT INTO PRODUCT_TYPE (NAME, PRODUCT_ID) VALUES ('Laptops', 6);

INSERT INTO PRODUCT_TYPE (NAME, PRODUCT_ID) VALUES ('Tablets', 7);
INSERT INTO PRODUCT_TYPE (NAME, PRODUCT_ID) VALUES ('Tablets', 8);
INSERT INTO PRODUCT_TYPE (NAME, PRODUCT_ID) VALUES ('Tablets', 9);

INSERT INTO PRODUCT_TYPE (NAME, PRODUCT_ID) VALUES ('TVs', 10);
INSERT INTO PRODUCT_TYPE (NAME, PRODUCT_ID) VALUES ('TVs', 11);
INSERT INTO PRODUCT_TYPE (NAME, PRODUCT_ID) VALUES ('TVs', 12);

-- FEATURES

-- OS
INSERT INTO FEATURES (NAME, VALUE) VALUES ('OS', 'Android');
INSERT INTO FEATURES (NAME, VALUE) VALUES ('OS', 'IOS');
-- Diagonal
INSERT INTO FEATURES (NAME, VALUE) VALUES ('Diagonal', '5');
INSERT INTO FEATURES (NAME, VALUE) VALUES ('Diagonal', '4.7');
INSERT INTO FEATURES (NAME, VALUE) VALUES ('Diagonal', '6');
INSERT INTO FEATURES (NAME, VALUE) VALUES ('Diagonal', '10');
INSERT INTO FEATURES (NAME, VALUE) VALUES ('Diagonal', '9');
-- Weight
INSERT INTO FEATURES (NAME, VALUE) VALUES ('Weight', '120');
INSERT INTO FEATURES (NAME, VALUE) VALUES ('Weight', '140');
INSERT INTO FEATURES (NAME, VALUE) VALUES ('Weight', '160');
INSERT INTO FEATURES (NAME, VALUE) VALUES ('Weight', '180');
-- Producer
INSERT INTO FEATURES (NAME, VALUE) VALUES ('Producer', 'Samsung');
INSERT INTO FEATURES (NAME, VALUE) VALUES ('Producer', 'LG');
INSERT INTO FEATURES (NAME, VALUE) VALUES ('Producer', 'Apple');
INSERT INTO FEATURES (NAME, VALUE) VALUES ('Producer', 'Xiaomi');


CREATE TABLE BROWSING (type INT DEFAULT 1);
-- TODO
