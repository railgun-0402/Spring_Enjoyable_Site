-- hotels
CREATE TABLE IF NOT EXISTS hotels (
    id                  SERIAL       NOT NULL PRIMARY KEY,
    name                VARCHAR(50)  NOT NULL,
    image_name          VARCHAR(255) NOT NULL,
    description         VARCHAR(255) NOT NULL,
    price               INT          NOT NULL,
    capacity            INT          NOT NULL,
    postal_code         VARCHAR(50)  NOT NULL,
    address             VARCHAR(255) NOT NULL,
    phone_number        VARCHAR(50)  NOT NULL,
    created_at          TIMESTAMP    DEFAULT CURRENT_TIMESTAMP,
    updated_at          TIMESTAMP    DEFAULT CURRENT_TIMESTAMP
);

-- roles
CREATE TABLE IF NOT EXISTS roles (
    id SERIAL PRIMARY KEY,
    role_name VARCHAR(50) NOT NULL
);

-- users
CREATE TABLE IF NOT EXISTS users (
     id                  SERIAL       NOT NULL PRIMARY KEY,
     name                VARCHAR(50)  NOT NULL,
     furigana            VARCHAR(50)  NOT NULL,
     postal_code         VARCHAR(50)  NOT NULL,
     address             VARCHAR(255) NOT NULL,
     phone_number        VARCHAR(50)  NOT NULL,
     email               VARCHAR(255) NOT NULL UNIQUE,
     password            VARCHAR(255) NOT NULL,
     enabled             BOOLEAN      NOT NULL,
     created_at          TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
     updated_at          TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
     role_id             INTEGER REFERENCES roles(id)
 );
