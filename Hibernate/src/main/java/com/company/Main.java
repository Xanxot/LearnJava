package com.company;

import com.company.dbService.DataSourceH2;
import com.company.dbService.DbService;
import com.company.dbService.DbServiceHibernate;
import com.company.dbService.DbServiceImpl;

import javax.sql.DataSource;

public class Main {

    public static void main(String[] args) throws Exception {
      //  DataSource dataSource = new DataSourceH2();
      //  User user = new User(1L, "NotJohn", 21);
      //  CreateDemoDB createDemoDB = new CreateDemoDB("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1",
      //          "create table user (id bigint(20) NOT NULL auto_increment, " +
      //                  "name varchar(255), age int(3))");
      //  DbService<User> dbService = new DbServiceImpl<>(dataSource);
      //  System.out.println(user.toString());
      //  dbService.save(user);
      //  user.setName("John");
      //  user.setId(3L);
      //  dbService.save(user);
      //  System.out.println(user.toString());
      //  user.setId(2L);
      //  dbService.save(user);
      //  System.out.println(user.toString());
      //  user = dbService.load(1, User.class);
      //  System.out.println("--------------");
      //  System.out.println(user.toString());
      //  dbService.load(2L,User.class);
        User user = new User(1L,"John",23);

        DbService<User> dbService = new DbServiceHibernate();
        dbService.save(user);
        dbService.load(2L,User.class);


    }
}
