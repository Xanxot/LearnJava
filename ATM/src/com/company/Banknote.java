package com.company;

public enum Banknote {

    FIFTY(50),
    ONE_HUNDRED(100),
    TWO_HUNDRED(200),
    FIVE_HUNDRED(500),
    ONE_THOUSAND(1000),
    //TWO_THOUSAND(2000),
    FIVE_THOUSAND(5000);


    public final int value;

    Banknote(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
