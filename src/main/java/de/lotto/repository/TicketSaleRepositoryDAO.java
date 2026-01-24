package de.lottohessen.repository;

import de.lottohessen.model.TicketSale;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import de.lottohessen.etl.dto.DailySalesAggregate;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;


public class TicketSaleRepository {

    public void save(TicketSale sale) throws SQLException {
        String sql = " INSERT INTO TICKET_SALE" +
            "(sale_id, draw_id, retailer_id, ticket_price, sale_timestamp)" +
            "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, sale.getSaleId());
            stmt.setInt(2, sale.getDrawId());
            stmt.setInt(3, sale.getRetailerId());
            stmt.setBigDecimal(4, sale.getTicketPrice());
            stmt.setTimestamp(5, java.sql.Timestamp.valueOf(sale.getSaleTimestamp()));

            stmt.executeUpdate();
        }
    }

    public DailySalesAggregate aggregateDailySales(LocalDate date) throws SQLException {

        String sql =
                "SELECT " +
                "CAST(sale_timestamp AS DATE) AS sales_date, " +
                "COUNT(*) AS total_tickets, " +
                "SUM(ticket_price) AS total_revenue " +
                "FROM TICKET_SALE " +
                "WHERE CAST(sale_timestamp AS DATE) = '" + date + "' " +
                "GROUP BY CAST(sale_timestamp AS DATE)";

        try (Connection conn = DatabaseConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                return new DailySalesAggregate(
                        rs.getDate("sales_date").toLocalDate(),
                        rs.getInt("total_tickets"),
                        rs.getBigDecimal("total_revenue")
                );
        }
    }

    return new DailySalesAggregate(date, 0, BigDecimal.ZERO);
    }
}
