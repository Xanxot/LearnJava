package com.company;

import java.util.Map;

public interface Store {
    void add(Banknote banknote);

    void out(int count);

    int getBalance();

    Map<Banknote, Integer> getStats();

    void restore();

}
