CREATE TABLE user(CustomerId INT AUTO_INCREMENT primary key,FirstName varchar(30) not null,LastName varchar(30) not null,dob DATE not null, Gender varchar(10) not null,
 City varchar(10),Country varchar(10),Email varchar(40),Annual_salary INT not null );
 
 DROP TABLE user;
 SELECT * FROM user;
 ALTER TABLE user AUTO_INCREMENT = 100;
 