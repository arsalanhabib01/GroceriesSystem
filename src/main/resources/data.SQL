DROP TABLE drinks;

CREATE TABLE drinks (
    id SERIAL PRIMARY KEY,
    name varchar(255),
    price int
);

INSERT INTO drinks (name, price) VALUES
('juice', 0), ('kaffe', 0), ('läsk', 0), ('mjölk', 0);


DROP TABLE juices;

CREATE TABLE juices (
                        id SERIAL PRIMARY KEY,
                        image varchar(255),
                        name varchar(255),
                        price int,
                        volume varchar(255)
);

INSERT INTO juices (image, name, price, volume) VALUES
('image/drinks/juices/Aplesin-Juice.jpg', 'Apelsin Juice', 29, '250 ml'),
('image/drinks/juices/Multivitamin.jpg', 'Multivitamin', 35, '500 ml'),
('image/drinks/juices/SUN-TROPICAL.jpg', 'Sun Tropical', 41, '10 x 20ml');


DROP TABLE kaffes;

CREATE TABLE kaffes (
                        id SERIAL PRIMARY KEY,
                        image varchar(255),
                        name varchar(255),
                        price int,
                        volume varchar(255)
);

INSERT INTO kaffes (image, name, price, volume) VALUES
('image/drinks/kaffes/mellanrost.jpg', 'Mellan Rost', 65, '470g'),
('image/drinks/kaffes/Mörkrost.jpg', 'Mörk Rost', 50, '200g');


DROP TABLE soda;

CREATE TABLE soda (
                      id SERIAL PRIMARY KEY,
                      image varchar(255),
                      name varchar(255),
                      price int,
                      volume varchar(255)
);

INSERT INTO soda (image, name, price, volume) VALUES
('image/drinks/sodas/pepsi_max.jpg', 'Pepsi Max', 25, '1,5L'),
('image/drinks/sodas/loka_paron.jpg', 'Löka Paron', 40, '12 x 33cl'),
('image/drinks/sodas/påskmust.jpg', 'Påskmust', 7, '1 x 33cl'),
('image/drinks/sodas/trocadero.jpg', 'Trocadero', 12, '1 x 33cl'),
('image/drinks/sodas/cola-zero.jpg', 'Coca Cola Zero', 65, '20 x 33cl');

DROP TABLE milk;

CREATE TABLE milk (
                      id SERIAL PRIMARY KEY,
                      image varchar(255),
                      name varchar(255),
                      price int,
                      volume varchar(255)
);

INSERT INTO milk (image, name, price, volume) VALUES
('image/drinks/milks/Standard-mjölk.jpg', 'Standard Mjölk', 12, '3% Fett x 1L'),
('image/drinks/milks/Mellan-mjölk.jpg', 'Mellan Mjölk', 9, '1.5% Fett x 1L'),
('image/drinks/milks/Lätt-mjölk.jpg', 'Lätt Mjölk', 7, '0.5% Fett x 1L');



DROP TABLE breads;

CREATE TABLE breads (
                        id SERIAL PRIMARY KEY,
                        name varchar(255),
                        price int
);

INSERT INTO breads (name, price) VALUES
('baguetter', 0), ('rostbröd', 0);


DROP TABLE baguettes;

CREATE TABLE baguettes (
                          id SERIAL PRIMARY KEY,
                          image varchar(255),
                          name varchar(255),
                          price int,
                          volume varchar(255)
);

INSERT INTO baguettes (image, name, price, volume) VALUES
('image/breads/baguettes/levinbröd.jpg', 'Levin Baguettes', 7, '50g'),
('image/breads/baguettes/baguette_hel.jpg', 'Baguette', 16, '250g'),
('image/breads/baguettes/baguette-vitlok.jpg', 'Baguette Vitlök', 23, '2 x 250g');


DROP TABLE toasts;

CREATE TABLE toasts (
                       id SERIAL PRIMARY KEY,
                       image varchar(255),
                       name varchar(255),
                       price int,
                       volume varchar(255)
);

INSERT INTO toasts (image, name, price, volume) VALUES
('image/breads/toasts/Originalrost.jpg', 'Originalrost', 31, '750g'),
('image/breads/toasts/pågenLimpan.jpg', 'PågenLimpan', 26, '800g'),
('image/breads/toasts/LANTBRÖD.jpg', 'LantBröd', 28, '550g');


DROP TABLE fruits;

CREATE TABLE fruits (
                        id SERIAL PRIMARY KEY,
                        name varchar(255),
                        price int
);

INSERT INTO fruits (name, price) VALUES
('orange', 0);


DROP TABLE vegetables;

CREATE TABLE vegetables (
                        id SERIAL PRIMARY KEY,
                        name varchar(255),
                        price int
);

INSERT INTO vegetables (name, price) VALUES
('spenat', 0);

DROP TABLE vegetables;

DROP TABLE carts;

CREATE TABLE carts (
    id SERIAL PRIMARY KEY,
    order_id int,
    product_name varchar(255),
    product_id int,
    amount int
);







