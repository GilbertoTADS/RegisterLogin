create database engineering;

USE engineering;

CREATE TABLE `USER`(
	id INT NOT NULL auto_increment primary key ,
    `name` VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
    pass VARCHAR(50) NOT NULL,
    birthDate datetime,
    created_in datetime default  now(),
    deleted_in datetime,
    updated_in datetime
);