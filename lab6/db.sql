CREATE TABLE Users(
  id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL
);

DESCRIBE Users;

CREATE TABLE Generators(
  id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  description TEXT,
  rate INTEGER,
  base_cost INTEGER,
  unlock_at INTEGER,
  created_by INTEGER,
  FOREIGN KEY (created_by) REFERENCES Users(id)
  );

DESCRIBE Generators;

CREATE TABLE Events(
  id INTEGER NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  description TEXT,
  trigger_at INTEGER,
  created_by INTEGER,
  PRIMARY KEY (id),
  FOREIGN KEY (created_by) REFERENCES Users(id)
);

DESCRIBE Events;

CREATE TABLE Quantities(
  generator_id INTEGER NOT NULL,
  token VARCHAR(255),
  quantity INTEGER DEFAULT 0,
  FOREIGN KEY (generator_id) REFERENCES Generators(id)
);

DESCRIBE Quantities;

INSERT INTO Users (username, password) VALUES
  ("admin", "cs3220password"), ("me", "notapassword");

SELECT * FROM Users;

INSERT INTO Generators VALUES
  (1, "Grandma", "Grandma likes to make cookies", 5, 10, 10, 1),
  (2, "Factory", "Factory to produce cookies", 10, 50, 50, 1),
  (3, "Mine", "Mining cookies", 20, 200, 200, 2);

SELECT * FROM Generators;

INSERT INTO Events VALUES
 (1, "Grandma shows up", "You always know grandma likes to make cookies", 10, 1),
 (2, "You can construct factory now!", "Factory to produce cookies", 50, 1),
 (3, "We've found cookies in deep mountain ... in the mine?", "Mining cookies", 200, 2),
 (4, "sample event", "This is a sample event. Please delete me", 99999, 2);

SELECT * FROM Events;

INSERT INTO Quantities VALUES
  (1, "c7a69d44e0b9b415b2d9956cb26b944a", 2),
  (2, "c7a69d44e0b9b415b2d9956cb26b944a", 1),
  (1, "80516ce4663c3bd0c8385309a2fe226e", 20),
  (2, "80516ce4663c3bd0c8385309a2fe226e", 30);

SELECT * FROM Quantities;

UPDATE Generators
  SET unlock_at=10, rate=1
  WHERE (name = "grandma");

SELECT * FROM Generators;

SELECT a.base_cost, a.description, a.name, b.quantity, a.rate, a.unlock_at FROM Generators a
  JOIN Quantities b
  ON a.id = b.generator_id
  WHERE b.token = "80516ce4663c3bd0c8385309a2fe226e";

SELECT * FROM Generators WHERE unlock_at = (
    SELECT MAX(unlock_at) FROM Generators
  );

SELECT * FROM Generators ORDER BY unlock_at;

DELETE FROM Events
  WHERE name = "sample event";

SELECT * FROM Events;
