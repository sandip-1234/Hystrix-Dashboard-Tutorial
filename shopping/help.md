<html>
<p>
How to enable hystrix circuit breaker dashboard in spring boot application.

Following steps can be used to test this application

<b>Email Service</b>
Start emailService Service and test it
http://localhost:8181/emailService/sendEmail


<b>Payment Service</b>
Start payment Service and test it.
http://localhost:8282/paymentService/payTM
http://localhost:8282/paymentService/amazonPay


<b>Shopping Service</b>
Start shopping Service on your local machine. Make sure you are using following annotation to use hystrix @EnableHystrix @EnableHystrixDashboard.

Use following annotation if you want to use fall back method. 
@HystrixCommand(groupKey = "Book Now", commandKey = "Book Now", fallbackMethod = "shoppingFallBack") 
shoppingFallBack method will be automatically used emailService or paymentService is down. 

Test shopping service is working or not using following url. 
http://localhost:8080/shopPayTM
http://localhost:8080/shopAmazonPay
http://localhost:8080/shopWithoutHystrix


Now down either emailService or payment service and again test following service and see the difference. 
http://localhost:8080/shopPayTM
http://localhost:8080/shopAmazonPay
http://localhost:8080/shopWithoutHystrix


To setup hystrix dashboard use following url and enter required information.

http://localhost:8080/hystrix

It will redirect you on hystrix dashboard. Now enter following properties on the text box given there. 
URL :- http://localhost:8080/actuator/hystrix.stream 
Title :- Sandeep Matolia

</p>
</html>