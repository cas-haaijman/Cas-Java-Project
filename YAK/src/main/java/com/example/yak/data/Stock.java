package com.example.yak.data;

public class Stock {
    private double milk;
    private int skins;

    public Stock(double milk, int skins) {
        this.milk = milk;
        this.skins = skins;
    }

    public Stock() {

    }

    public double getMilk() {
        return milk;
    }

    public void setMilk(double milk) {
        this.milk = milk;
    }

    public int getSkins() {
        return skins;
    }

    public void setSkins(int skins) {
        this.skins = skins;
    }

    static Stock emptyStock() {
        return new Stock(0,0);
    }
}
