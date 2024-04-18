DROP TABLE IF EXISTS `booking`;
CREATE TABLE `booking`
(
    `id`        bigint(20) NOT NULL AUTO_INCREMENT,
    `customer_id`        bigint(20) NOT NULL,
    `payment_status`  varchar(20)  DEFAULT NULL,
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE `reservation`
(
    `id`        bigint(20) NOT NULL AUTO_INCREMENT,
    `booking_id`        bigint(20) NOT NULL,
    `room_id`        bigint(20) NOT NULL,
    `from`      DATE NOT NULL,
    `to`      DATE NOT NULL,
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`
(
    `id`        bigint(20) NOT NULL AUTO_INCREMENT,
    `name`  varchar(20)  DEFAULT NULL,
    `address_id`   bigint(20),
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `address`;
CREATE TABLE `address`
(
    `id`        bigint(20) NOT NULL AUTO_INCREMENT,
    `line1`  varchar(100)  DEFAULT NULL,
    `line2`  varchar(100)  DEFAULT NULL,
    `city`  varchar(50)  DEFAULT NULL,
    `state`  varchar(50)  DEFAULT NULL,
    `country`  varchar(50)  DEFAULT NULL,
    `zip`   int(5),
    `type`  varchar(50)  DEFAULT NULL,
    PRIMARY KEY (`id`)
);