package com.company;

import java.sql.*;
import java.util.HashMap;

public class ExecutorImpl implements Executor {

    private static final String URL = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
    private final Connection connection;
    HashMap<String, String> data = null;
    Reflection reflection;

    public ExecutorImpl(Object obj) throws Exception {
        this.reflection = new Reflection(obj);
        if (this.data == null) {
            this.data = reflection.getResult();
        }
        this.connection = DriverManager.getConnection(URL);
        this.connection.setAutoCommit(false);
    }

    @Override
    public void save(Object objectData) throws Exception {
        this.reflection = new Reflection(objectData);
        this.data = reflection.getResult();

        int cursor = 1;
        StringBuilder keyBuilder = new StringBuilder("(");
        StringBuilder valueBuilder = new StringBuilder("(");

        for (String key : data.keySet()) {
            keyBuilder.append(key).append(", ");
            valueBuilder.append("?").append(", ");
        }

        valueBuilder.setLength(valueBuilder.length() - 2);
        valueBuilder.append(")");
        keyBuilder.setLength(keyBuilder.length() - 2);
        keyBuilder.append(")");

        String query = "insert into " + reflection.getName() + " " + keyBuilder + " values " + valueBuilder;

        System.out.println(query);

        PreparedStatement sv = connection.prepareStatement(query);

        for (String value : data.values()) {
            sv.setString(cursor++, value);
        }

        System.out.println(sv);

        sv.executeUpdate();
        sv.close();
    }


    @Override
    public Object load(long id, Class clazz) throws Exception {
        HashMap<String, Object> values = new HashMap<>();
        String query = "Select * from " + clazz.getSimpleName() + " where " + reflection.getPrimaryKey() + " = ?";

        System.out.println(query);
        PreparedStatement sel = connection.prepareStatement(query);
        sel.setString(1, Long.toString(id)); //Сюда лоничнее передавать String, но по тз long
        ResultSet resultSet = sel.executeQuery();
        System.out.println(resultSet);
        int row=1;
        while (resultSet.next()) {
            for (int i = 1; i <= data.size(); i++) {
                values.put("row"+row+": "+resultSet.getMetaData().getColumnName(i), resultSet.getObject(i));
            }
            row++;
        }

        resultSet.close();
        sel.close();

        return values.toString();
    }
}

