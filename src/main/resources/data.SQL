DROP TABLE drinks;

CREATE TABLE drinks (
    id SERIAL PRIMARY KEY,
    name varchar(255),
    price int
);

INSERT INTO drinks (name, price) VALUES
('juice', 0), ('kaffe', 0), ('läsk', 0), ('mjölk', 0);




