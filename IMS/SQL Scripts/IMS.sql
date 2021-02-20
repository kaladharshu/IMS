CREATE SCHEMA `ims` ;
use ims;
drop user 'admin'@'localhost';
create user 'admin'@'localhost' identified by 'pass123';
GRANT ALL PRIVILEGES ON ims.* TO 'admin'@'localhost' WITH GRANT OPTION;

CREATE TABLE `product` (
  `product_id` int NOT NULL,
  `product_name` varchar(100) DEFAULT NULL,
  `product_desc` varchar(100) DEFAULT NULL,
  `package_size` varchar(20) DEFAULT NULL,
  `retail_price` decimal(17,2),
  `selling_price` decimal(17,2),
  PRIMARY KEY (`product_id`)
);
CREATE TABLE `stock` (
  `product_id` int NOT NULL,
  `quantity` int NOT NULL,
  `selling_price` decimal(17,2) NOT NULL,
  PRIMARY KEY (`product_id`),
  KEY `FK_PROD_ID` (`product_id`),
  FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
);
CREATE TABLE `purchase` (
  `product_id` int NOT NULL,
  `quantity` int NOT NULL,
  `purchase_price` decimal(17,2) NOT NULL,
  `purchase_date` date NOT NULL,
  KEY `FK_PROD_ID` (`product_id`),
  FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
);
CREATE TABLE `sale` (
  `product_id` int NOT NULL,
  `quantity` int NOT NULL,
  `sale_price` decimal(17,2) NOT NULL,
  `sale_date` date NOT NULL,
  KEY `FK_PROD_ID` (`product_id`),
  FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
);
CREATE TABLE `user_account` (
  `user` varchar(100) unique not null,
  `pass` varchar(100) not null
);
INSERT INTO `ims`.`product` (`product_id`,`product_name`,`product_desc`,`package_size`)
VALUES
(101, 'coke','soft drinks','1L'),
(102, 'pepsi','soft drinks','.5L'),
(103, 'dr pepper','soft drinks','1L'),
(104, 'maaza','soft drinks','.75L'),
(105, 'fanta','soft drinks','1L'),
(106, 'sprite','soft drinks','2L');
select * from product;
INSERT INTO `ims`.`stock`(`product_id`,`quantity`,`selling_price`)
VALUES
(101,100,15.50),
(102,300,16.50),
(103,400,17.50),
(104,500,18.50),
(105,600,19.50),
(106,700,20.50);
select * from stock;
select * from purchase;
select * from sale;



