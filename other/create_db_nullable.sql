drop database if exists bookmaker;

create database bookmaker;

use bookmaker;

CREATE TABLE teams (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(45)
);

CREATE TABLE bookmakers (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(45),
    balance DECIMAL(14 , 2 )
);

CREATE TABLE operators (
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(45),
    last_name VARCHAR(45),
    email VARCHAR(45),
    password VARCHAR(45),
    bookmaker_id INT,
    FOREIGN KEY (bookmaker_id)
        REFERENCES bookmakers (id)
);

CREATE TABLE matches (
    id INT PRIMARY KEY AUTO_INCREMENT,
    outcome TINYINT DEFAULT NULL,
    match_date DATETIME,
    home_team_id INT,
    visiting_team_id INT,
    operator_id INT,
    FOREIGN KEY (home_team_id)
        REFERENCES teams (id),
    FOREIGN KEY (visiting_team_id)
        REFERENCES teams (id),
    FOREIGN KEY (operator_id)
        REFERENCES operators (id)
);

CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    balance DECIMAL(11 , 2 ),
    first_name VARCHAR(45),
    last_name VARCHAR(45),
    email VARCHAR(45),
    password VARCHAR(45),
    bookmaker_id INT,
    FOREIGN KEY (bookmaker_id)
        REFERENCES bookmakers (id)
);

CREATE TABLE transactions (
    id INT PRIMARY KEY AUTO_INCREMENT,
    transaction_date DATETIME,
    amount DECIMAL(11 , 2 ),
    transaction_type TINYINT,
    currency CHAR(3) default "RSD",
    rate DECIMAL(12, 6) default 1.000000,
    conversion_log VARCHAR(255) default "No conversion",
    user_id INT,
    bookmaker_id INT,
    FOREIGN KEY (user_id)
        REFERENCES users (id),
    FOREIGN KEY (bookmaker_id)
        REFERENCES bookmakers (id)
);

CREATE TABLE tickets (
    id INT PRIMARY KEY AUTO_INCREMENT,
    bet_amount DECIMAL(11 , 2 ),
    won TINYINT,
    user_id INT,
    FOREIGN KEY (user_id)
        REFERENCES users (id)
);

CREATE TABLE matches_tickets (
    id INT PRIMARY KEY AUTO_INCREMENT,
    outcome_prediction TINYINT,
    ticket_id INT,
    match_id INT,
    FOREIGN KEY (ticket_id)
        REFERENCES tickets (id),
    FOREIGN KEY (match_id)
        REFERENCES matches (id)
);