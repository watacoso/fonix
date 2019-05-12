
DROP TABLE IF EXISTS observers;
DROP TABLE IF EXISTS flights;

CREATE TABLE observers(
id INT AUTO_INCREMENT PRIMARY KEY,
email VARCHAR,
origCode VARCHAR,
destCode VARCHAR,
frequencyCode INT
);


CREATE TABLE flights(
id INT AUTO_INCREMENT PRIMARY KEY,
userId INT ,
origCode VARCHAR,
destCode VARCHAR,
flightCode VARCHAR,
departureDate DATE,
pricing DECIMAL(9,2)
);