package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CreateDemoDB {
    private final String URL;
    private final String SQL;

    public CreateDemoDB(String dataSource, String SQL) throws Exception {
        this.URL = dataSource;
        this.SQL = SQL;
        createTable();
    }

    private void createTable() throws Exception {
        try (Connection connection = DriverManager.getConnection(URL)) {
            connection.setAutoCommit(false);
            PreparedStatement pst = connection.prepareStatement(SQL);
            System.out.println(pst);
            pst.executeUpdate();
        }


    }
}
