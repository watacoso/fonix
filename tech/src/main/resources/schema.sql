
DROP TABLE IF EXISTS observers;
DROP TABLE IF EXISTS flights;

CREATE TABLE observers(
email VARCHAR,
origCode VARCHAR,
destCode VARCHAR,
frequencyCode VARCHAR,
bestPrice DECIMAL(9,2),
nextUpdate TIMESTAMP default CURRENT_TIMESTAMP,
primary key(email,origCode,destCode)
);


CREATE TABLE flights(
origCode VARCHAR,
destCode VARCHAR,
flightCode VARCHAR,
departureDate TIMESTAMP,
pricing DECIMAL(9,2),
primary KEY(origCode,destCode,flightCode,departureDate)
);

