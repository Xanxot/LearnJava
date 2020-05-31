package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CreateDemoDB {
    private static final String URL = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";

    public CreateDemoDB() throws Exception {
        Connection connection = DriverManager.getConnection(URL);
        connection.setAutoCommit(false);

        PreparedStatement pst = connection.prepareStatement
                ("create table user (id bigint(20) NOT NULL auto_increment, " +
                        "name varchar(255), age int(3))");

        System.out.println(pst);
        pst.executeUpdate();
        pst.close();
    }
}
