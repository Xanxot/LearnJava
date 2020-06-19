package com.company;

import java.util.*;

public interface Store {

    Map<Banknote, BanknoteCell> banknoteCell = new HashMap<>();

    void add(Banknote banknote);

    void out(int count) throws Exception;

    int getBalance();

    Map getStats();


}
