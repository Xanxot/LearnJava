package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class StoreImpl implements Store {
    AtmStateSaver atmStateSaver;

    private Map<Banknote, BanknoteCell> banknoteCell = new HashMap<>();


    public StoreImpl() {
        for (var Name : Banknote.values()) {
            BanknoteCellImpl banknoteCellImpl = new BanknoteCellImpl(Name, 10);
            banknoteCell.put(Name, banknoteCellImpl);

        }
        startRestoreService();
    }

    @Override
    public void add(Banknote banknote) {

        banknoteCell.get(banknote).add(banknote);
    }


    private void startRestoreService() {
        this.atmStateSaver = new AtmStateSaver(banknoteCell.values());

    }


    @Override
    public void out(int count) {
        int counter = count;
        Integer[] values = new Integer[banknoteCell.size()];
        Banknote[] Names = Banknote.values();
        Arrays.sort(Names, Collections.reverseOrder());
        int c = 0;
        for (var Name : Banknote.values()) {
            values[c++] = banknoteCell.get(Name).getValue();
        }
        Arrays.sort(values, Collections.reverseOrder());

        int extradition = 0;

        for (int i = 0; i < values.length; i++) {
            int denominator;
            if (counter / values[i] >= 1 && banknoteCell.get(Names[i]).getCount() > 0) {
                denominator = counter / values[i];
                System.out.println(values[i] + " " + counter / values[i]);
                if (banknoteCell.get(Names[i]).getCount() < denominator) {
                    denominator = banknoteCell.get(Names[i]).getCount();

                }
                extradition += values[i] * denominator;
                counter -= values[i] * denominator;
                banknoteCell.get(Names[i]).out(denominator);

            }
        }
        if (extradition != count) {
            throw new ATMCashOutException("В ATM недостаточно средств");
        }
        System.out.println(extradition);

    }

    @Override
    public int getBalance() {
        int balance = 0;
        for (var Name : Banknote.values()) {

            balance = balance + banknoteCell.get(Name).getBalance();
        }
        return balance;
    }


    @Override
    public Map<Banknote, Integer> getStats() {
        Map<Banknote, Integer> info = new HashMap<>();
        for (var Name : Banknote.values()) {
            info.putAll(banknoteCell.get(Name).stat());
        }
        System.out.println(info);
        return info;
    }

    @Override
    public void restore() {
        this.banknoteCell = atmStateSaver.restore();
    }


}
