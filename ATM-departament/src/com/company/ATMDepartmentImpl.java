package com.company;

import java.util.*;

public class ATMDepartmentImpl<T> implements ATMDepartment {

    private final List<ATM> atm = new ArrayList<>();
    private final CommandGenerator commandGenerator = new CommandGenerator();

    public ATMDepartmentImpl(Collection<ATM> atm) {
        this.atm.addAll(atm);
        this.atm.forEach(commandGenerator::addListener);
    }

    @Override
    public void resetAllATM() {
        commandGenerator.reset();

    }

    @Override
    public int getBalance() {
        int balance = 0;
        for (ATM atm : atm) {
            balance += atm.balance();
        }
        return balance;
    }
}
