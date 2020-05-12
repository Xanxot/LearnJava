package com.company;

import java.util.Map;

public interface BanknoteCell {
    void add(Banknote banknote);

    void out(int count);

    Map stat();

    int getBalance();

    int getCount();

    int getPrice();
}
