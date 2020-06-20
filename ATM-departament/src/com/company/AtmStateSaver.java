package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class AtmStateSaver {


    private final HashMap<Banknote, BanknoteCell> backup = new HashMap<>();
    private final List<BanknoteCell> banknoteCells = new ArrayList<>();

    public AtmStateSaver(Collection<BanknoteCell> banknoteCells) {
        copy(banknoteCells);
        save();
    }

    private void copy(Collection<BanknoteCell> cells) {
        for (BanknoteCell banknoteCell : cells) {
            Banknote banknote = Banknote.valueOf(banknoteCell.getName());
            BanknoteCell bc = new BanknoteCellImpl(banknote);
            for (int i = 0; i < banknoteCell.getCount(); i++) {
                bc.add(banknote);
            }
            this.banknoteCells.add(bc);
        }
    }

    public void save() {
        for (BanknoteCell banknoteCell : banknoteCells) {
            backup.put(banknoteCell.getBanknote(), banknoteCell);
        }
    }

    public HashMap<Banknote, BanknoteCell> restore() {
        System.out.println("Atm has been restored"); //todo logger
        return backup;
    }
}