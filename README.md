Loan Management System

1. Introduction

The Loan Management System is a web-based application designed to manage loan-related operations for a financial institution. It has two main roles, Admin and User.

2. Features

2.1 For Admin Role:
Add customer information.
Create loan 
View all loans and their statuses.


2.2 For User Role:
List loans.
Viev loan installments

3. System Architecture

3.1 Technology Stack

Backend: Spring Boot 3.1
Database: H2 in memory database
Authentication: Spring Security with Basic Authentication
Build Tool: Maven
Server: Apache Tomcat (embedded in Spring Boot)

3.2 High-Level Diagram

Client makes API requests.

Backend validates requests via basic authentication.

Database handles CRUD operations for customers, loans, and installments.

4. API Endpoints

4.1.POST   /api/admin/customers         Add new customer      ADMIN
4.2.POST   /api/admin/loans             Create new loan       ADMIN
4.3.GET   /api/user/list-loan           List loans            ADMIN,USER
4.4.GET   /api//user/installments       List installments     ADMIN,USER
4.5.PUT   /api//admin/pay-installment   Pay loan installment  ADMIN

5. Prerequisites:

Install Java 17 and Maven.

Set up H2 database 

------------------------------------------------------------------------
Running Application
1. mvn clean package (Java 17 required)
2. java -jar your_target_path/LoanManagementSystem-0.0.1-SNAPSHOT.jar

------------------------------------------------------------------------
Using Application
1. It is recommended to first create a customer.
   POST http://localhost:8080/api/admin/customers
   {
    "name":"Ali",
    "surname":"Test",
    "creditLimit":40000,
    "usedCredit":10000
   }
2. Create loan for created customer.
   POST http://localhost:8080/api/admin/loans
   {
    "customerId": 1,
    "amount": 2000,
    "interestRate":0.50,
    "installments":6
   }
3. List Loans and Loan Insallments.
   GET http://localhost:8080/api/installments?loanId=1
   GET http://localhost:8080/api/user/list-loans?customerId=1

NOTE: There are two role defination in application. User and Admin. Passwords and Usernames for this two roles are stored in application properties file and must authenticate with Basic Auth. before sending requests.



   
