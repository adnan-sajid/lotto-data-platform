# Requirements – Lottery Data Processing System

## 1. Objective
The goal of this project is to design and implement a Java-based system for
processing lottery draw and ticket sales data. The system prepares operational
data for analytical and reporting purposes in a structured and reliable way.

## 2. Scope
The system covers the following functional areas:
- Management of lottery draws
- Processing of ticket sales transactions
- Aggregation of sales data for reporting (ETL-style processing)
- Storage of aggregated results in a relational database

The project focuses on backend processing and does not include a user interface.

## 3. Functional Requirements

### FR-1 Lottery Draw Management
- The system shall store lottery draw information including draw date and draw numbers.

### FR-2 Ticket Sales Processing
- The system shall store ticket sales transactions with references to lottery draws.
- Each sale shall include ticket price and retailer information.

### FR-3 Data Aggregation (ETL)
- The system shall aggregate ticket sales per draw.
- The system shall calculate total revenue per draw.
- The system shall calculate the number of tickets sold per draw.

### FR-4 Reporting Data Storage
- Aggregated results shall be stored in dedicated reporting tables.
- Reporting tables shall be optimized for analytical queries.

## 4. Non-Functional Requirements
- The system shall use a relational database.
- The system shall be implemented in Java using object-oriented principles.
- The system shall be modular and maintainable.
- The system shall include automated tests for critical components.
- The system shall be documented in a structured and understandable way.

## 5. Assumptions
- The system is intended for internal analytical use.
- Data volumes are moderate and suitable for batch processing.
- Data correctness and traceability are prioritized over performance optimizations.

## 6. Out of Scope
- User interface development
- Real-time processing
- External system integrations
