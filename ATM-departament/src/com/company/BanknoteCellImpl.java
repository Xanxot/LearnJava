package com.company;

import java.util.HashMap;
import java.util.Map;

public class BanknoteCellImpl implements BanknoteCell {
    Banknote nameOfBanknote;

    int countOfBanknote = 0;
    private final Map<Banknote, Integer> info = new HashMap<>();

    public BanknoteCellImpl(Banknote banknote, int countOfBanknote) {
        this.nameOfBanknote = banknote;
        this.countOfBanknote = countOfBanknote;
    }

    public BanknoteCellImpl(Banknote banknote) {
        this.nameOfBanknote = banknote;
    }

    @Override
    public int getValue() {
        return nameOfBanknote.value;
    }

    @Override
    public String getName() {

        return nameOfBanknote.toString();
    }

    @Override
    public void add(Banknote banknote) {
        if (!banknote.equals(nameOfBanknote)) {
            throw new ATMCashOutException("В ATM недостаточно средств");

        } else
            countOfBanknote++;

    }

    @Override
    public void out(int count) {
        countOfBanknote -= count;
    }

    @Override
    public Banknote getBanknote() {
        return nameOfBanknote;
    }

    @Override
    public Map<Banknote, Integer> stat() {
        info.put(nameOfBanknote, countOfBanknote);
        return info;
    }

    @Override
    public int getBalance() {

        return nameOfBanknote.value * countOfBanknote;
    }

    @Override
    public int getCount() {
        return countOfBanknote;
    }


}
