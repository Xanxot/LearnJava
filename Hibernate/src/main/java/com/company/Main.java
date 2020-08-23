package com.company;

import com.company.dbService.DbService;
import com.company.dbService.DbServiceHibernate;
import com.company.dbService.entities.User;

public class Main {

    public static void main(String[] args) throws Exception {
        User user = new User(1L,"John",22);
        DbService dbService = new DbServiceHibernate();
        dbService.save(user);


    }
}
