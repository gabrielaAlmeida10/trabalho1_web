drop database Library;
create database Library;
use Library;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(15)
);

CREATE TABLE books (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    author VARCHAR(100) NOT NULL,
    publisher VARCHAR(100) NOT NULL,
    genre VARCHAR(100) NOT NULL,
    years int,
    quantity INT DEFAULT 1,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE loans (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(200),
    book_name VARCHAR(100),
    loan_date DATE,
    return_date DATE,
    returned BOOLEAN DEFAULT FALSE
);

select * from users;
select * from books;
select * from loans;

