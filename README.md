# spring-boot-hystrix-dashboard
How to enable hystrix circuit breaker dashboard in spring boot application.

Following steps can be used to test this application

Start emailService Service. Test email service is running or not using 'http://localhost:8181/emailService/sendEmail'

Start payment Service. Test payment service is running or not using 'http://localhost:8282/paymentService/payTM' or 'http://localhost:8282/paymentService/amazonPay'

Start shopping Service. Make sure you are using following annotation to use hystrix @EnableHystrix @EnableHystrixDashboard Use following annotation if you want to use fall back method. @HystrixCommand(groupKey = "Book Now", commandKey = "Book Now", fallbackMethod = "shoppingFallBack") shoppingFallBack method will be automatically used emailService or paymentService is down. Test shopping service is working or not using following url. http://localhost:8080/shopPayTM http://localhost:8080/shoppingAmazonPay http://localhost:8080/shopAmazonPay

Now down either emailService or payment service and again test following service and see the difference. http://localhost:8080/shopPayTM http://localhost:8080/shoppingAmazonPay http://localhost:8080/shopAmazonPay

YouTube Link = https://www.youtube.com/watch?v=A2IhEwbniLI

Setup hystrix dashboard. type http://localhost:8080/hystrix on browser.

It will redirect you on hystrix dashboard. Now enter following properties on the text box given there. URL :- http://localhost:8080/actuator/hystrix.stream Title :- Sandeep Matolia

Now click on monitor button.
