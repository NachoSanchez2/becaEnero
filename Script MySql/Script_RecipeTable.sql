CREATE TABLE recipe (
	id int NOT NULL AUTO_INCREMENT,
    recipeName VARCHAR(100) NOT NULL,
    recipeDescription VARCHAR(200) NOT NULL,
    url VARCHAR(200),
    valoration DOUBLE,
    PRIMARY KEY(id));