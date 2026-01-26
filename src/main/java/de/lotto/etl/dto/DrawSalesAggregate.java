package de.lotto.etl.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DrawSalesAggregate {

	private final int drawId;
    private final int totalTicketsSold;
    private final BigDecimal totalRevenue;
    private final LocalDate aggregationDate;
    
    public DrawSalesAggregate(
    		int drawId,
            int totalTicketsSold,
            BigDecimal totalRevenue,
            LocalDate aggregationDate
    ) {
    	this.drawId = drawId;
        this.totalTicketsSold = totalTicketsSold;
        this.totalRevenue = totalRevenue;
        this.aggregationDate = aggregationDate;
    }

    public int getDrawId() {
    	return drawId;
    }
    
    
    public int getTotalTicketsSold() {
        return totalTicketsSold;
    }

    public BigDecimal getTotalRevenue() {
        return totalRevenue;
    }
    
    public LocalDate getAggregationDate() {
        return aggregationDate;
    }
}
