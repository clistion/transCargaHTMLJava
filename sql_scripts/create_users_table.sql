CREATE TABLE IF NOT EXISTS users (
  username VARCHAR(50) PRIMARY KEY,
  password VARCHAR(255) NOT NULL,
  role VARCHAR(50) NOT NULL
);
INSERT INTO users (username, password, role)
VALUES ('admin', 'admin123', 'ADMIN');
