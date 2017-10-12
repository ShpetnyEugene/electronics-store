INSERT INTO USER (login,password,role) VALUES ('user','user',2);
INSERT INTO USER (login,password,role) VALUES ('admin','admin',1);
INSERT INTO USER (login,password,role) VALUES ('eugene','123',1);

INSERT INTO PRODUCT (name,price,amount,description,rating) VALUES('Iphone-8',1000,100,'Phone for rich',0);
INSERT INTO PRODUCT (name,price,amount,description,rating) VALUES('Samsung-s8',900,100,'Phone for not rich',0);

INSERT INTO PRODUCT_IMAGES VALUES (1,'/images/phone/iphone-8.jpeg');
INSERT INTO PRODUCT_IMAGES VALUES (2,'/images/phone/samsung-s8.jpeg');
