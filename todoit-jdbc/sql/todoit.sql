CREATE DATABASE IF NOT EXISTS todoit;
USE todoit;

CREATE TABLE IF NOT EXISTS person (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    birth_date DATE
);

CREATE TABLE IF NOT EXISTS todo_item (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    description TEXT,
    deadline DATE,
    is_completed BOOLEAN,
    assignee_id INT,
    FOREIGN KEY (assignee_id) REFERENCES person(id)
);
