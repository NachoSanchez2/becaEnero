CREATE TABLE ingredient (
	id int NOT NULL AUTO_INCREMENT,
    ingredientName VARCHAR(100) NOT NULL,
    amount DOUBLE NOT NULL,
    price DOUBLE,
    PRIMARY KEY(id));