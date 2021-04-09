CREATE TABLE IF NOT EXISTS drinks (
    id INT PRIMARY KEY,
    name varchar(255),
    price int
);

INSERT INTO drinks (name, price) VALUES
('juice', 0), ('kaffe', 0), ('läsk', 0), ('mjölk', 0);
