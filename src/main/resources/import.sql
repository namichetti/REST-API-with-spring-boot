INSERT INTO `db_rest_api`.`customers` (`address`, `phone`) VALUES ('Wall Street 102', '3451278456');
INSERT INTO `db_rest_api`.`customers` (`address`, `phone`) VALUES ('Avellaneda 145', '4646323');
INSERT INTO `db_rest_api`.`customers` (`address`, `phone`) VALUES ('Mitre 200 BIS', '145235879');
INSERT INTO `db_rest_api`.`customers` (`address`, `phone`) VALUES ('Citric 1245', '12457892');
INSERT INTO `db_rest_api`.`customers` (`address`, `phone`) VALUES ('Oregon 1245', '124578888');


INSERT INTO `db_rest_api`.`products` (`name`, `price`) VALUES ('Coca cola', '100');
INSERT INTO `db_rest_api`.`products` (`name`, `price`) VALUES ('Pepsi', '105');
INSERT INTO `db_rest_api`.`products` (`name`, `price`) VALUES ('Fanta', '70');
INSERT INTO `db_rest_api`.`products` (`name`, `price`) VALUES ('Red Bull', '140');
INSERT INTO `db_rest_api`.`products` (`name`, `price`) VALUES ('Monster', '75');


INSERT INTO `db_rest_api`.`orders` (`date`, `status`, `customer_id`,`total`) VALUES ('2021-05-18 18:43:06', 1, 1, 0);
INSERT INTO `db_rest_api`.`orders` (`date`, `status`, `customer_id`,`total`) VALUES ('2021-04-11 10:03:06', 1, 1, 0);
INSERT INTO `db_rest_api`.`orders` (`date`, `status`, `customer_id`,`total`) VALUES ('2020-12-21 19:43:06', 1, 2, 0);
INSERT INTO `db_rest_api`.`orders` (`date`, `status`, `customer_id`,`total`) VALUES ('2020-11-18 18:43:06', 0, 3, 0);
INSERT INTO `db_rest_api`.`orders` (`date`, `status`, `customer_id`,`total`) VALUES ('2021-05-04 10:13:06', 0, 4, 0);

INSERT INTO `db_rest_api`.`items` (`quantity`, `order_id`, `product_id`) VALUES ('30', '1', '1');
INSERT INTO `db_rest_api`.`items` (`quantity`, `order_id`, `product_id`) VALUES ('3', '1', '1');
INSERT INTO `db_rest_api`.`items` (`quantity`, `order_id`, `product_id`) VALUES ('2', '2', '2');
INSERT INTO `db_rest_api`.`items` (`quantity`, `order_id`, `product_id`) VALUES ('1', '3', '2');
INSERT INTO `db_rest_api`.`items` (`quantity`, `order_id`, `product_id`) VALUES ('19', '4', '4');
INSERT INTO `db_rest_api`.`items` (`quantity`, `order_id`, `product_id`) VALUES ('20', '4', '3');
INSERT INTO `db_rest_api`.`items` (`quantity`, `order_id`, `product_id`) VALUES ('10', '5', '5');
