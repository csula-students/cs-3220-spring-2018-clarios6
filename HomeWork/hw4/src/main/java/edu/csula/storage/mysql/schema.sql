CREATE TABLE Users(
  id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL
);

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

CREATE TABLE Events(
  id INTEGER NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  description TEXT,
  trigger_at INTEGER,
  created_by INTEGER,
  PRIMARY KEY (id),
  FOREIGN KEY (created_by) REFERENCES Users(id)
);

CREATE TABLE Quantities(
  generator_id INTEGER NOT NULL,
  token VARCHAR(255),
  quantity INTEGER DEFAULT 0,
  FOREIGN KEY (generator_id) REFERENCES Generators(id)
);

INSERT INTO Users (username, password) VALUES
  ("admin", "cs3220password"), ("me", "notapassword");

INSERT INTO Generators VALUES
  (1, "Slave", "A run of the mill slave it generates one ore per minute", 5, 10, 10, 1),
  (2, "Robot", "An expensive robot that generates 10 ores per minute", 10, 15, 30, 1),
  (3, "Advanced Robot", "A state-of-the-art robot. It generates 20 ores per minute", 20, 20, 100, 1);

INSERT INTO Events VALUES
 (1, "Slave shows up", "Slave mining ores", 10, 1),
 (2, "Robots are invented", "Robots mine faster than slaves", 15, 1),
 (3, "Advanced Robots created", "Advanced Robots just do it better", 20, 1),
