CREATE TABLE message(
  id int NOT NULL AUTO_INCREMENT,
  origin int DEFAULT NULL,
  destination int DEFAULT NULL,
  message varchar(255) DEFAULT NULL,
  datetimemessage datetime DEFAULT NULL,
  readed tinyint DEFAULT '0',
  PRIMARY KEY (id),
  KEY FK_USER_1_idx (origin),
  KEY FK_USER_2_idx (destination),
  CONSTRAINT FK_USER_1 FOREIGN KEY (origin) REFERENCES user (idUser),
  CONSTRAINT FK_USER_2 FOREIGN KEY (destination) REFERENCES user (idUsermessage2)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
