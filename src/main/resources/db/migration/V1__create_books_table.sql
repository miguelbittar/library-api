CREATE TABLE books (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    isbn VARCHAR(13) UNIQUE,
    available_copies INTEGER NOT NULL DEFAULT 1,
    author VARCHAR(255) NOT NULL,
    category VARCHAR(50) NOT NULL,
    publisher VARCHAR(255)
);