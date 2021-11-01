package com.example.yak.data;

import java.util.LinkedList;

public class Herd{
    private LinkedList<LabYak> herd;

    public Herd(LinkedList<LabYak> herd) {
        this.herd = herd;
    }

    public Herd() {
    }

    public LinkedList<LabYak> getHerd() {
        return herd;
    }

    public void setHerd(LinkedList<LabYak> herd) {
        this.herd = herd;
    }

    public Stock milkAndShave(int daysElapsed) {
        double totalMilk = 0;
        int totalSkins = 0;

        for (LabYak yak : herd) {
            totalMilk += yak.milk(daysElapsed);
            totalSkins += yak.shave(daysElapsed);
        }

        return new Stock(totalMilk, totalSkins);
    }

    public Herd age(int daysElapsed) {
        LinkedList<LabYak> newHerd = new LinkedList<>();

        for (LabYak yak : herd) {
            yak.age(daysElapsed).ifPresent(labYak -> {
                newHerd.add(labYak);
            });
        }

        return new Herd(newHerd);
    }
}
