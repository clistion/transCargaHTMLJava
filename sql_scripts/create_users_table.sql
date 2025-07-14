CREATE TABLE IF NOT EXISTS users (
  username VARCHAR(50) PRIMARY KEY,
  password VARCHAR(255) NOT NULL,
  role VARCHAR(50) NOT NULL
);
INSERT INTO users (username, password, role)
VALUES ('lima', '$2a$12$qwHVWNpAsVKpllfL/ZVIpO1gwUvpz1I3Y1pEoZVUhKRNWr0aiqjNG', 'ADMIN');
