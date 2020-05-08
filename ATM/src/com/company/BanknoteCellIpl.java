package com.company;

import java.util.HashMap;
import java.util.Map;

public class BanknoteCellIpl implements BanknoteCell {
    Banknote nameOfBanknote;
    int price;
    int countOfBanknote = 0;
    private final Map<Banknote, Integer> info = new HashMap<>();

    @Override
    public void add(Banknote banknote) throws Exception {
        if (!banknote.equals(nameOfBanknote)){
            throw new Exception (new ATMCashOutException("В ATM недостаточно средств"));

        }else
            countOfBanknote++;

    }

    @Override
    public void out(int count) {
        countOfBanknote -=count;
    }

    @Override
    public Map stat() {
        info.put(nameOfBanknote, countOfBanknote);
        return info;
    }

    @Override
    public int getBalance() {

        return price * countOfBanknote;
    }

    @Override
    public int getCount() {
        return countOfBanknote;
    }


    public BanknoteCellIpl(Banknote banknote, int countOfBanknote) {
        this.nameOfBanknote = banknote;
        this.price = Banknote.valueOf(nameOfBanknote.toString()).value;
        this.countOfBanknote = countOfBanknote;

    }
}
