package com.example.yak.data;

import org.apache.commons.lang3.tuple.Pair;

import java.util.Optional;

public class LabYak implements Cloneable {
    String name;
    double ageInDays;
    Sex sex;
    double ageLastShaved;

    public LabYak(String name, float ageInDays, Sex sex) {
        this.name = name;
        this.ageInDays = ageInDays;
        this.sex = sex;
        ageLastShaved = 0;
    }

    public LabYak() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAgeInDays() {
        return ageInDays;
    }

    public double getAgeLastShaved() {
        return ageLastShaved;
    }

    public void setAgeLastShaved(double ageLastShaved) {
        this.ageLastShaved = ageLastShaved;
    }

    public void setAgeInDays(double ageInDays) {
        this.ageInDays = ageInDays;
    }

    public Pair<Stock, Optional<LabYak>> ageUp(int daysElapsed) {

        LabYak olderYak;
        try {
            olderYak = (LabYak) this.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        } //TODO: EW

        double milk = 0;
        int skins = 0;

        for(double days = 0; days < daysElapsed; days++) {
            double newAge = ageInDays + days;

            if(newAge == Constants.daysInYakLife) {
                return Pair.of(new Stock(milk, skins), Optional.empty());
            }

            olderYak.setAgeInDays(newAge);
            skins += olderYak.tryToShave() ? 1 : 0;
            milk += olderYak.milk();
        }

        return Pair.of(new Stock(milk, skins), Optional.of(olderYak));

    }

    public double milk() {
        return 50 - 0.015 * ageInDays;
    }

    private boolean canBeShaved() {
        return ageInDays - ageLastShaved >= 8 + 0.01 * ageInDays &&
                ageInDays >= Constants.ageOfFirstShave;
    }

    public boolean tryToShave() {
        if(canBeShaved()) {
            ageLastShaved = ageInDays;
            return true;
        }
        return false;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
