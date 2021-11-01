package com.example.yak.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Farm {
//    Herd herd;
//    Stock stock;

    static private Herd dummyHerd = new Herd(new LinkedList<LabYak>(
            Arrays.asList(
                    new LabYak("Betty-1", 400, Sex.FEMALE),
                    new LabYak("Betty-2", 800, Sex.FEMALE),
                    new LabYak("Betty-3", 950, Sex.FEMALE)
                    )
    ));

    public static Stock getStockFromElapsedDays(int daysElapsed) {
        //TODO: implement database retrieval of yak data
        Herd herd = dummyHerd;
        return herd.milkAndShave(daysElapsed);
    }

    public static Herd getHerdFromElapsedDays(int daysElapsed) {
        //TODO: implement database retrieval of yak data
        Herd herd = dummyHerd;
        return herd.age(daysElapsed);
    }
}
