package com.company;

import java.util.Map;

public interface BanknoteCell {
    void add(Banknote banknote);

    void out(int count);

    Banknote getBanknote();

    Map<Banknote, Integer> stat();

    int getBalance();

    int getCount();

    String getName();

    int getValue();
}
