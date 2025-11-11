package com.stockmarket;

public class Portfolio {

    private double cash;
    private StockHolding[] holdings;
    private int holdingsCount;

    private static class StockHolding {
        private Stock stock;
        private int quantity;

        public StockHolding(Stock stock, int quantity) {
            this.stock = stock;
            this.quantity = quantity;
        }
    }

    public Portfolio(double initialCash) {
        this.cash = initialCash;
        this.holdings = new StockHolding[10];
        this.holdingsCount = 0;
    }

    public void addStock(Stock stock, int quantity) {
        for (StockHolding holding : this.holdings) {
            if (holding != null && holding.stock.equals(stock)) {
                holding.quantity += quantity;
                return;
            }
        }

        if (this.holdingsCount < this.holdings.length) {
            this.holdings[this.holdingsCount++] = new StockHolding(stock, quantity);
        } else {
            System.out.println("UWAGA! Pełen portfel.");
        }
    }

    public double calculateStockValue() {
        double total = 0.0;
        for (StockHolding holding : this.holdings) {
            if (holding != null) {
                total += holding.stock.getValue() * holding.quantity;
            }
        }
        return total;
    }

    public double calculateTotalValue() {
        return this.cash + this.calculateStockValue();
    }

    public double getCash() {
        return this.cash;
    }

    public int getHoldingsCount() {
        return this.holdingsCount;
    }

    public int getStockQuantity(Stock stock) {
        for (StockHolding holding : this.holdings) {
            if (holding != null && holding.stock.equals(stock)) {
                return holding.quantity;
            }
        }
        return 0;
    }
}