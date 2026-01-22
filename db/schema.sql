-- =============================================
-- Lottery Data Processing System - Database Schema
-- =============================================

-- Master table: Lottery Draw
CREATE TABLE LOTTERY_DRAW (
    draw_id        INT PRIMARY KEY,
    draw_date      DATE NOT NULL,
    draw_numbers   VARCHAR(50) NOT NULL
);

-- Reference table: Retailer
CREATE TABLE RETAILER (
    retailer_id    INT PRIMARY KEY,
    retailer_name  VARCHAR(100) NOT NULL
);

-- Transaction table: Ticket Sales
CREATE TABLE TICKET_SALE (
    sale_id        INT PRIMARY KEY,
    draw_id        INT NOT NULL,
    retailer_id    INT NOT NULL,
    ticket_price   DECIMAL(8,2) NOT NULL,
    sale_timestamp TIMESTAMP NOT NULL,

    CONSTRAINT fk_sale_draw
        FOREIGN KEY (draw_id) REFERENCES LOTTERY_DRAW(draw_id),

    CONSTRAINT fk_sale_retailer
        FOREIGN KEY (retailer_id) REFERENCES RETAILER(retailer_id)
);

-- Reporting / DWH table: Aggregated Sales per Draw
CREATE TABLE DRAW_SALES_FACT (
    draw_id              INT PRIMARY KEY,
    total_tickets_sold   INT NOT NULL,
    total_revenue        DECIMAL(12,2) NOT NULL,
    aggregation_date     DATE NOT NULL
);
