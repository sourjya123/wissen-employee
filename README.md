# wissen-employee

spring-eureka-company-service is registered in eureka as WISSEN-SERVICE and it is running on port 9098
spring-eureka-employee-service is registered in eureka as EMPLOYEE-SERVICE and it is running on port 8098

3 APIs are exposed outside
1. POST Employee <br>
   url: http://<machine-ip-address>:9098/wissen/employee/
   Format : {
        "first_Name": "Sourjya",
        "last_Name": "Dutta",
        "address": "Bangalore E City"
    }
   Response: 201 Created
   Response Header: New-Employee - Sourjya Dutta
   
 2. GET All Employees
    url: http://<machine-ip-address>:9098/wissen/employee/
    Response Body: [
    {
        "id": 1,
        "first_Name": "Sourjya",
        "last_Name": "Dutta",
        "address": "Bangalore"
    },
    {
        "id": 2,
        "first_Name": "Arpita",
        "last_Name": "Pal",
        "address": "Kolkata"
    }
  ]
  
  2. GET Particular Employee
    url: http://<machine-ip-address>:9098/wissen/employee/1
    Response Body:
    {
        "id": 1,
        "first_Name": "Sourjya",
        "last_Name": "Dutta",
        "address": "Bangalore"
    }
 
 I am using in memory database (h2-database)
 url : http://<machine-ip-address>:8098/h2-console
 username: sa
 password: password
  
 For caching the data create a folder call 'test' in your local machine and mention the path in application.properties file of spring-eureka-employee-service
eg,
spring.datasource.url=jdbc:h2:file:C:/Users/sourjyak1/test
