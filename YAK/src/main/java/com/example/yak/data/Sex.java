package com.example.yak.data;

public enum Sex {
    FEMALE("f"), MALE("m"), OTHER("o");

    private final String inputString;

    Sex(String inputString) {
        this.inputString = inputString;
    }
}
