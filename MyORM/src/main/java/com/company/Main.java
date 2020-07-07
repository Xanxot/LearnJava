package com.company;

import com.company.dbService.DataSourceH2;
import com.company.dbService.DbServiceImpl;

import javax.sql.DataSource;

public class Main {

    public static void main(String[] args) throws Exception {
        DataSource dataSource = new DataSourceH2();
        User user = new User(1L, "NotJohn", 21);
        CreateDemoDB createDemoDB = new CreateDemoDB("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1",
                "create table user (id bigint(20) NOT NULL auto_increment, " +
                        "name varchar(255), age int(3))");

        DbServiceImpl dbService = new DbServiceImpl<User>(dataSource);
        user.print();
        dbService.save(user);
        user.setName("John");
        user.setId(3L);
        dbService.save(user);
        user.print();
        user.setId(2L);
        dbService.save(user);
        user.print();
        user = (User) dbService.load(1, User.class);
        System.out.println("--------------");
        user.print();


    }
}
