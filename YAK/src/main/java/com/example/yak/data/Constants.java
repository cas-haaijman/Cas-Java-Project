package com.example.yak.data;

import java.util.Arrays;
import java.util.LinkedList;

public class Constants {
    static double daysInYear = 100;
    static double daysInYakLife = 1000;
    static double ageOfFirstShave = Constants.daysInYear;

    static private final Herd dummyHerd = new Herd(new LinkedList<>(
            Arrays.asList(
                    new LabYak("Betty-1", 400, Sex.FEMALE),
                    new LabYak("Betty-2", 800, Sex.FEMALE),
                    new LabYak("Betty-3", 950, Sex.FEMALE)
            )
    ));
    static public Farm dummyFarm = new Farm(dummyHerd, Stock.emptyStock());
}
