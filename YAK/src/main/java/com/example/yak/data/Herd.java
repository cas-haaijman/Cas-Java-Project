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

}
