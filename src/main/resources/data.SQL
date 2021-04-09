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
('image/drinks/juices/Multivitamin.jpg', 'Multivitamin', 35, '500 ml');


