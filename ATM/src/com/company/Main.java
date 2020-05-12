package com.company;


import java.util.ArrayList;
import java.util.Collection;

import static com.company.Banknote.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Collection<Banknote> banknotes = new ArrayList<>();
        banknotes.add(FIFTY);
        banknotes.add(FIVE_THOUSAND);
        banknotes.add(FIFTY);
        ATM atm = new ATM();
        atm.getStats();
        atm.withdrawal(banknotes);
        atm.getStats();
        atm.out(5000);
        atm.getStats();



    }
}
