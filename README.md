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
   



   
