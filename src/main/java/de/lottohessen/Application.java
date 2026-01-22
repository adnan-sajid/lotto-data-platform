package de.lottohessen;

import de.lottohessen.model.TicketSale;
import de.lottohessen.repository.TicketSaleRepository;
import de.lottohessen.service.TicketSaleService;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Application {

    public static void main(String[] args) {

        TicketSaleRepository repository = new TicketSaleRepository();
        TicketSaleService service = new TicketSaleService(repository);

        TicketSale sale = new TicketSale(
                1,
                1001,
                10,
                new BigDecimal("8.50"),
                LocalDateTime.now()
        );

        try {
            service.registerSale(sale);
            System.out.println("Ticket sale registered successfully.");
        } catch (Exception e) {
            System.err.println("Error registering ticket sale: " + e.getMessage());
        }
    }
}
