package com.company;

import java.util.*;

public class StoreImpl implements Store {

    public StoreImpl() {
        for (var Name : Banknote.values()) {
            BanknoteCell banknote = new BanknoteCellIpl(Name, 3);
            banknoteCell.put(Name, banknote);

        }

    }

    public void add(Banknote banknote) {

        banknoteCell.get(banknote).add(banknote);

    }

    public void out(int count) throws Exception {
        int counter = count;
        Integer[] values = new Integer[banknoteCell.size()];
        Banknote[] Names = Banknote.values();
        Arrays.sort(Names, Collections.reverseOrder());
        int c = 0;
        for (var Name : Banknote.values()) {
            values[c++] = banknoteCell.get(Name).getPrice();
        }
        Arrays.sort(values, Collections.reverseOrder());

        int extradition = 0;

        for (int i = 0; i < values.length; i++) {
            int denominator;
            if (counter / values[i] >= 1 && banknoteCell.get(Names[i]).getCount() > 0) {
                denominator = counter / values[i];
                if (banknoteCell.get(Names[i]).getCount() < denominator) {
                    denominator = banknoteCell.get(Names[i]).getCount();

                }
                extradition += values[i] * denominator;
                counter -= values[i] * denominator;
                banknoteCell.get(Names[i]).out(denominator);

            }
        }
        if (extradition != count) {
            //Пока так, но позже можно засунуть сюда memento
            throw new Exception(new ATMCashOutException("В ATM недостаточно средств"));
        }

    }

    public int getBalance() {
        int balance = 0;
        for (var Name : Banknote.values()) {

            balance = balance + banknoteCell.get(Name).getBalance();

        }
        return balance;

    }

    public Map getStats() {
        int balance = 0;
        Map<Banknote, Integer> info = new HashMap<>();
        Map tempInfo;
        for (var Name : Banknote.values()) {
            balance = balance + banknoteCell.get(Name).getBalance();
            tempInfo = banknoteCell.get(Name).stat();
            info.putAll(tempInfo);

        }

        return info;
    }


}
