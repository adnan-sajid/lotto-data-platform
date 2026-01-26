package de.lotto.etl.batch;

import java.sql.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import de.lotto.etl.dto.DailySalesAggregate;

public class DailySalesETLJob {

    private final Connection connection;

    public DailySalesETLJob(Connection connection) {
        this.connection = connection;
    }

    public List<DailySalesAggregate> extractAndTransform() throws SQLException {

        String sql = "SELECT " +
                "DATE(sale_time) AS sales_date, " +
                "draw_id, " +
                "SUM(ticket_price) AS total_revenue," +
                "COUNT(*) AS total_tickets" +
            "FROM ticket_sales" +
            "GROUP BY DATE(sale_time), " + "draw_id";

        List<DailySalesAggregate> aggregates = new ArrayList<>();

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
            	aggregates.add(new DailySalesAggregate(
                        rs.getDate("sales_date").toLocalDate(),
                        rs.getInt("draw_id"),
                        rs.getInt("total_tickets"),
                        rs.getBigDecimal("total_revenue")
                        
                ));
            }
        }
        return aggregates;
    }
}
