DROP TABLE IF EXISTS hotel;
CREATE TABLE hotel
(
    id  INT NOT NULL AUTO_INCREMENT,
    name    VARCHAR(20)  DEFAULT NULL,
    address_id  INT,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS room;
CREATE TABLE room
(
    id  INT NOT NULL AUTO_INCREMENT,
    hotel_id    INT,
    type    VARCHAR(20)  DEFAULT NULL,
    status  VARCHAR(20)  DEFAULT NULL,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS booking;
CREATE TABLE booking
(
    id  INT NOT NULL AUTO_INCREMENT,
    customer_id INT NOT NULL,
    payment_status  VARCHAR(20)  DEFAULT NULL,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS reservation;
CREATE TABLE reservation
(
    id  INT NOT NULL AUTO_INCREMENT,
    booking_id  INT NOT NULL,
    room_id INT NOT NULL,
    start   DATE NOT NULL,
    end DATE NOT NULL,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS customer;
CREATE TABLE customer
(
    id  INT NOT NULL AUTO_INCREMENT,
    name    VARCHAR(20)  DEFAULT NULL,
    address_id  INT,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS address;
CREATE TABLE address
(
    id  INT NOT NULL AUTO_INCREMENT,
    line1   VARCHAR(100)  DEFAULT NULL,
    line2   VARCHAR(100)  DEFAULT NULL,
    city    VARCHAR(50)  DEFAULT NULL,
    state   VARCHAR(50)  DEFAULT NULL,
    country VARCHAR(50)  DEFAULT NULL,
    zip INT,
    type    VARCHAR(50)  DEFAULT NULL,
    PRIMARY KEY (id)
);