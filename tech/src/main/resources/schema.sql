
DROP TABLE IF EXISTS observers;
DROP TABLE IF EXISTS flights;

CREATE TABLE observers(
id INT AUTO_INCREMENT PRIMARY KEY,
email VARCHAR,
origCode VARCHAR,
destCode VARCHAR,
frequencyCode VARCHAR,
bestPrice DECIMAL(9,2),
nextUpdate DATE default CURRENT_TIMESTAMP
);


CREATE TABLE flights(
origCode VARCHAR,
destCode VARCHAR,
flightCode VARCHAR,
departureDate DATE,
pricing DECIMAL(9,2)
);

