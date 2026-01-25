package de.lotto.etl.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DailySalesAggregate {

    private final LocalDate salesDate;
    private int drawId;
    private final int totalTickets;
    private final BigDecimal totalRevenue;

    public DailySalesAggregate(
            LocalDate salesDate,
            int drawId,
            int totalTickets,
            BigDecimal totalRevenue
    ) {
        this.salesDate = salesDate;
        this.drawId = drawId;
        this.totalTickets = totalTickets;
        this.totalRevenue = totalRevenue;
    }

    public LocalDate getSalesDate() {
        return salesDate;
    }
    
    public int getdrawId(){
        return drawId;
    }

    public int getTotalTickets() {
        return totalTickets;
    }

    public BigDecimal getTotalRevenue() {
        return totalRevenue;
    }
}
