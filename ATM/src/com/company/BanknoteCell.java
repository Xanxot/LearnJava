package com.company;

import java.util.Map;

public interface BanknoteCell {
    public void add(Banknote banknote) throws Exception;

    public void out(int count);

    public Map stat();

    public int getBalance();

    public int getCount();
}
