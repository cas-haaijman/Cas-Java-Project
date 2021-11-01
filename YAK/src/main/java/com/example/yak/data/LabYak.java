package com.example.yak.data;

import java.util.Optional;

public class LabYak {
    String name;
    double ageInDays;
    Sex sex;
    double ageLastShaved;

    public LabYak(String name, float ageInDays, Sex sex) {
        this.name = name;
        this.ageInDays = ageInDays;
        this.sex = sex;
        ageLastShaved = Float.MAX_VALUE;
    }

    public LabYak(String name, double ageInDays, Sex sex, double ageLastShaved) {
        this.name = name;
        this.ageInDays = ageInDays;
        this.sex = sex;
        this.ageLastShaved = ageLastShaved;
    }

    public Optional<LabYak> age(int daysElapsed) {
        if(ageInDays + daysElapsed > Constants.daysInYakLife) {
            return Optional.empty();
        }

        return Optional.of(
                new LabYak(name, ageInDays + daysElapsed, sex, ageLastShaved)
        );
    }

    public double milk(int daysElapsed) {
        double daysDead = Double.max(0, ageInDays + daysElapsed - Constants.daysInYakLife);
        double daysElapsedBeforeDeath = daysElapsed - daysDead;

        // Formula based on the fact that each day a labYak produces 50-D*0.03 liters of milk
        return 50 * daysElapsedBeforeDeath - 0.015 * Math.pow(daysElapsedBeforeDeath, 2);
    }

    public int shave(int daysElapsed) {

        double ageIter = Double.max(ageInDays, Constants.ageOfFirstShave);
        double finalAge = Double.min(ageInDays + daysElapsed, Constants.daysInYakLife);
        int yield = 0;

        // Each Math.floor(8 + 0.01 * ageCount) days the yak is shaved at the start of the day
        // until the final age is reached
        while(finalAge >= ageIter) {
            ageIter += Math.floor(8 + 0.01 * ageIter);
            yield++;
        }

        return yield;
    }


}
