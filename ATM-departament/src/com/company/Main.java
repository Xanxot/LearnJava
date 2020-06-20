package com.company;

import java.util.ArrayList;
import java.util.Collection;

public class Main {
    public static void main(String[] args) throws Exception {

        Collection<ATM> atms = new ArrayList<>();
        ATM atm2 = new ATM();
        ATM atm1 = new ATM();
        ATM atm = new ATM();
        atms.add(atm);
        atms.add(atm1);
        atms.add(atm2);
        ATMDepartment atmDepartment = new ATMDepartmentImpl(atms);
        System.out.println(atmDepartment.getBalance());
        atm.out(650);
        atm2.out(450);
        System.out.println(atmDepartment.getBalance());
        atmDepartment.resetAllATM();
        System.out.println(atmDepartment.getBalance());


    }
}