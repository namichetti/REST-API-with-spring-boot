# REST API with Spring Boot

This REST API will be consumed for https://github.com/namichetti/webclient-spring-boot

<br /> <br />


![uml](https://user-images.githubusercontent.com/73079790/120826043-6a73ad00-c530-11eb-8a34-06fc3b400603.png)





## Customer

* POST: https://rest-api-customer.herokuapp.com/customer/
* GET:  https://rest-api-customer.herokuapp.com/customer/{customer_id}
* GET https://rest-api-customer.herokuapp.com/customer/{address}
* PUT:  https://rest-api-customer.herokuapp.com/customer/{customer_id}
* DELETE: https://rest-api-customer.herokuapp.com/customer/{customer_id}

## Order

* POST: https://rest-api-customer.herokuapp.com/order/{customer_id}
* GET:  https://rest-api-customer.herokuapp.com/order/{order_id}
* GET https://rest-api-customer.herokuapp.com/order/search?{firstDate=yyyy-MM-dd'T'HH:mm:ss&secondDate=yyyy-MM-dd'T'HH:mm:ss}
* PUT:  https://rest-api-customer.herokuapp.com/order/{order_id}/{customer_id}
* DELETE: https://rest-api-customer.herokuapp.com/order/{id}

## Item

* POST: https://rest-api-customer.herokuapp.com/item/{order_id}
* GET:  https://rest-api-customer.herokuapp.com/item/{item_id}}
* PUT:  https://rest-api-customer.herokuapp.com/item/{item_id}/{order_id}/{product_id}
* DELETE: https://rest-api-customer.herokuapp.com/item/{id}

## Product

* POST: https://rest-api-customer.herokuapp.com/product/
* GET:  https://rest-api-customer.herokuapp.com/product/{id}
* PUT:  https://rest-api-customer.herokuapp.com/product/{id}
