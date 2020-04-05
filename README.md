# wissen-employee

spring-eureka-company-service is registered in eureka as WISSEN-SERVICE and it is running on port 9098
spring-eureka-employee-service is registered in eureka as EMPLOYEE-SERVICE and it is running on port 8098

3 APIs are exposed outside
<b>1. POST Employee</b> <br>
   url: http://<machine-ip-address>:9098/wissen/employee/ <br>
   Format : {
        "first_Name": "Sourjya",
        "last_Name": "Dutta",
        "address": "Bangalore E City"
    } <br>
   Response: 201 Created <br>
   Response Header: New-Employee - Sourjya Dutta <br>
   
 <b>2. GET All Employees</b> <br>
    url: http://<machine-ip-address>:9098/wissen/employee/ <br>
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
  ] <br>
  
  <b>3. GET Particular Employee</b> <br>
    url: http://<machine-ip-address>:9098/wissen/employee/1 <br>
    Response Body:
    {
        "id": 1,
        "first_Name": "Sourjya",
        "last_Name": "Dutta",
        "address": "Bangalore"
    } <br>
 
 I am using in memory database (h2-database) <br>
 url : http://<machine-ip-address>:8098/h2-console <br>
 username: sa <br>
 password: password <br> <br>
  
 For caching the data create a folder call 'test' in your local machine and mention the path in application.properties file of spring-eureka-employee-service <br>
eg, <br>
spring.datasource.url=jdbc:h2:file:C:/Users/sourjyak1/test
