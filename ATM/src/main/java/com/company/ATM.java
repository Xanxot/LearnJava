package com.company;

import java.util.*;

import static com.company.Banknote.*;

public class ATM {
    Store store = new StoreImpl();

    public void out(int count) throws Exception {
        if (count<=0){
            throw new Exception(new ATMCashOutException("Значение должно быть больше 0"));
        }else {
            int minPrice = Integer.MAX_VALUE;
            for (var Name : Banknote.values()) {
                if (Name.value < minPrice) {
                    minPrice = valueOf(Name.toString()).value;
                }
            }
            if (count % minPrice != 0) {
                throw new Exception(new ATMCashOutException("Значение должно быть кратно " + minPrice));
            } else store.out(count);

        }
    }

    public void withdrawal(Collection<Banknote> banknotes) {
        banknotes.forEach(banknote -> store.add(banknote));


    }

    public int balance() {
        return store.getBalance();
    }

    protected void getStats() {
        Map banknoteValue = store.getStats();

        for (var Name : Banknote.values()) {

            System.out.println("В банкомате " + banknoteValue.get(Name).toString() + " банкнот " + Name + ", на сумму: "
                    + valueOf(Name.toString()).value * Integer.parseInt(banknoteValue.get(Name).toString()) + " рублей");


        }
        System.out.println("Сумма всех банкнот: " + store.getBalance());


    }





}
