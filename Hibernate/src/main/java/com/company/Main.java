package com.company;

import com.company.dbService.DbService;
import com.company.dbService.DbServiceHibernate;
import com.company.entities.User;

public class Main {

    public static void main(String[] args) throws Exception {
        User user = new User(1L,"John",22);
        DbService dbService = new DbServiceHibernate();
        dbService.save(user);
        user.setAge(23);
        dbService.load(1L,User.class);


    }
}
