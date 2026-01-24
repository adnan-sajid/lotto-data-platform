package de.lottohessen.service;

import de.lottohessen.model.TicketSale;
import de.lottohessen.repository.TicketSaleRepository;

import java.sql.SQLException;
import java.math.BigDecimal;

public class TicketSaleService {

    private final TicketSaleRepository repository;

    public TicketSaleService(TicketSaleRepository repository) {
        this.repository = repository;
    }

    /**
     * Business rule:
     * Ticket price must be positive and <= 50 EUR
     */
    public void registerSale(TicketSale sale) throws SQLException {
        validateSale(sale);
        repository.save(sale);
    }

    private void validateSale(TicketSale sale) {
        BigDecimal price = sale.getTicketPrice();

        if (price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Ticket price must be positive");
        }

        if (price.compareTo(new BigDecimal("50.00")) > 0) {
            throw new IllegalArgumentException("Ticket price exceeds maximum allowed value");
        }
    }
}
