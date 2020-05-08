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
        atm.withdrawal(banknotes);
       // atm.out(6950);

        //System.out.println(atm.withdrawal(new int[]{500, 12, 23, 50, 200, 100, 1000, 10, 5000, 500, 50}));
        //atm.withdrawal()
        //atm.balance();

      //  String[] messages = atm.getStats();
      //  for (String message : messages) {
      //      System.out.println(message);
      //  }


    }
}
