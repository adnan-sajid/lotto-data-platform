package de.lotto.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TicketSale {

    private int saleId;
    private int drawId;
    private int retailerId;
    private BigDecimal ticketPrice;
    private LocalDateTime saleTimestamp;

    public TicketSale(int saleId, int drawId, int retailerId,
                      BigDecimal ticketPrice, LocalDateTime saleTimestamp) {
        this.saleId = saleId;
        this.drawId = drawId;
        this.retailerId = retailerId;
        this.ticketPrice = ticketPrice;
        this.saleTimestamp = saleTimestamp;
    }

    public int getSaleId() {
        return saleId;
    }

    public int getDrawId() {
        return drawId;
    }

    public int getRetailerId() {
        return retailerId;
    }

    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    public LocalDateTime getSaleTimestamp() {
        return saleTimestamp;
    }
}
