package com.company;

import java.util.Collection;
import java.util.Map;

import static com.company.Banknote.valueOf;

public class ATM implements Listener {
    Store store = new StoreImpl();

    public void out(int count) {
        if (count <= 0) {
            throw new ATMCashOutException("Значение должно быть больше 0");
        } else {
            int minPrice = 2147483647;
            for (var Name : Banknote.values()) {
                if (valueOf(Name.toString()).value < minPrice) {
                    minPrice = valueOf(Name.toString()).value;
                }
            }
            if (count % minPrice != 0) {
                throw new ATMCashOutException("Значение должно быть кратно " + minPrice);
            } else store.out(count);
        }
    }

    public void withdrawal(Collection<Banknote> banknotes) {
        banknotes.forEach(banknote -> {
            try {
                store.add(banknote);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public int balance() {
        return store.getBalance();
    }

    protected Map<Banknote, Integer> getStats() {
        return store.getStats();
    }

    @Override
    public void reset() {
        store.restore();
    }
}
