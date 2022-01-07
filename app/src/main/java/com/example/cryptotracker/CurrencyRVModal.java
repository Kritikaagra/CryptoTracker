package com.example.cryptotracker;

public class CurrencyRVModal {
    private String name;
    private String symbol;
    private double price;
    private int id;
    private double twentyFour;
    private double sevenDays;
    private double thirtyDays;
    private double marketCap;

    public CurrencyRVModal(String name, String symbol, double price, int id, double twentyFour, double sevenDays, double thirtyDays, double marketCap) {
        this.name = name;
        this.symbol = symbol;
        this.price = price;
        this.id = id;
        this.twentyFour = twentyFour;
        this.sevenDays = sevenDays;
        this.thirtyDays = thirtyDays;
        this.marketCap = marketCap;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public double getTwentyFour() { return twentyFour; }

    public void setTwentyFour(double twentyFour) { this.twentyFour = twentyFour; }

    public double getSevenDays() { return sevenDays; }

    public void setSevenDays(double sevenDays) { this.sevenDays = sevenDays; }

    public double getThirtyDays() { return thirtyDays; }

    public void setThirtyDays(double thirtyDays) { this.thirtyDays = thirtyDays; }

    public double getMarketCap() { return marketCap; }

    public void setMarketCap(double marketCap) { this.marketCap = marketCap; }
}
