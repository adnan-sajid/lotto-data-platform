package de.lotto.model;

public class Retailer {

    private int retailerId;
    private String retailerName;

    public Retailer(int retailerId, String retailerName) {
        this.retailerId = retailerId;
        this.retailerName = retailerName;
    }

    public int getRetailerId() {
        return retailerId;
    }

    public String getRetailerName() {
        return retailerName;
    }
}
