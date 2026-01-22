package de.lottohessen.repository;

import de.lottohessen.model.TicketSale;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TicketSaleRepository {

    public void save(TicketSale sale) throws SQLException {
        String sql = """
            INSERT INTO TICKET_SALE
            (sale_id, draw_id, retailer_id, ticket_price, sale_timestamp)
            VALUES (?, ?, ?, ?, ?)
        """;

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
}
