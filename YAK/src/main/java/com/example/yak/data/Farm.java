package com.example.yak.data;

import org.apache.commons.lang3.tuple.Pair;

import java.util.LinkedList;
import java.util.Optional;

public class Farm {
    Herd herd;
    Stock stock;

    public Farm(Herd herd, Stock stock) {
        this.herd = herd;
        this.stock = stock;
    }

    public Herd getHerd() {
        return herd;
    }

    public Stock getStock() {
        return stock;
    }

    public Farm elapse(int daysElapsed) {
        double totalMilk = 0;
        int totalSkins = 0;
        LinkedList<LabYak> newHerd = new LinkedList<>();

        for (LabYak yak : herd.getHerd()) {
            Pair<Stock, Optional<LabYak>> result = yak.ageUp(daysElapsed);
            totalMilk += result.getLeft().getMilk();
            totalSkins += result.getLeft().getSkins();
            result.getRight().ifPresent(newHerd::add);
        }

        return new Farm(new Herd(newHerd), new Stock(totalMilk, totalSkins));
    }

}
