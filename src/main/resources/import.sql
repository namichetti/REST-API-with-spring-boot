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


INSERT INTO `db_rest_api`.`orders` (`date`, `status`, `customer_id`,`total`) VALUES ('2021-05-18 18:43:06', 1, 1, 1000);
INSERT INTO `db_rest_api`.`orders` (`date`, `status`, `customer_id`,`total`) VALUES ('2021-04-11 10:03:06', 1, 1, 100.50);
INSERT INTO `db_rest_api`.`orders` (`date`, `status`, `customer_id`,`total`) VALUES ('2020-12-21 19:43:06', 1, 2, 520);
INSERT INTO `db_rest_api`.`orders` (`date`, `status`, `customer_id`,`total`) VALUES ('2020-11-18 18:43:06', 0, 3, 453,33);
INSERT INTO `db_rest_api`.`orders` (`date`, `status`, `customer_id`,`total`) VALUES ('2021-05-0410:13:06', 0, 4, 1000);

INSERT INTO `db_rest_api`.`items` (`price`, `order_id`, `product_id`) VALUES ('300', '1', '1');
INSERT INTO `db_rest_api`.`items` (`price`, `order_id`, `product_id`) VALUES ('35', '1', '1');
INSERT INTO `db_rest_api`.`items` (`price`, `order_id`, `product_id`) VALUES ('20', '2', '2');
INSERT INTO `db_rest_api`.`items` (`price`, `order_id`, `product_id`) VALUES ('15', '3', '2');
INSERT INTO `db_rest_api`.`items` (`price`, `order_id`, `product_id`) VALUES ('199', '4', '4');
INSERT INTO `db_rest_api`.`items` (`price`, `order_id`, `product_id`) VALUES ('200', '4', '3');
INSERT INTO `db_rest_api`.`items` (`price`, `order_id`, `product_id`) VALUES ('100', '5', '5');
