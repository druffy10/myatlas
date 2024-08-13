-- Создание схемы базы данных
CREATE SCHEMA IF NOT EXISTS myatlas;

-- Создание таблицы пользователей
CREATE TABLE IF NOT EXISTS myatlas.users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Создание таблицы мест
CREATE TABLE IF NOT EXISTS myatlas.places (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    latitude DOUBLE PRECISION NOT NULL,
    longitude DOUBLE PRECISION NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Создание таблицы маршрутов
CREATE TABLE IF NOT EXISTS myatlas.routes (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    start_latitude DOUBLE PRECISION NOT NULL,
    start_longitude DOUBLE PRECISION NOT NULL,
    end_latitude DOUBLE PRECISION NOT NULL,
    end_longitude DOUBLE PRECISION NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Создание таблицы отзывов
CREATE TABLE IF NOT EXISTS myatlas.reviews (
    id SERIAL PRIMARY KEY,
    user_id INTEGER REFERENCES myatlas.users(id) ON DELETE CASCADE,
    place_id INTEGER REFERENCES myatlas.places(id) ON DELETE CASCADE,
    rating INTEGER CHECK (rating >= 1 AND rating <= 5),
    comment TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Вставка начальных данных (опционально)
INSERT INTO myatlas.users (username, password_hash, email)
VALUES ('admin', 'hashed_password', 'admin@example.com');

INSERT INTO myatlas.places (name, description, latitude, longitude)
VALUES ('Sample Place', 'A sample description', 40.712776, -74.005974);

INSERT INTO myatlas.routes (name, description, start_latitude, start_longitude, end_latitude, end_longitude)
VALUES ('Sample Route', 'A sample route description', 40.712776, -74.005974, 34.052235, -118.243683);

INSERT INTO myatlas.reviews (user_id, place_id, rating, comment)
VALUES (1, 1, 5, 'Excellent place!');

-- Создание индексов (опционально)
CREATE INDEX idx_users_email ON myatlas.users(email);
CREATE INDEX idx_places_location ON myatlas.places(latitude, longitude);
CREATE INDEX idx_reviews_user ON myatlas.reviews(user_id);
CREATE INDEX idx_reviews_place ON myatlas.reviews(place_id);
