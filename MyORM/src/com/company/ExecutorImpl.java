package com.company;

import java.sql.*;
import java.util.HashMap;

public class ExecutorImpl implements Executor {

    private static final String URL = "jdbc:h2:mem:";
    private final Connection connection;
    HashMap<String, String> data = null;
    Reflection reflection;

    public ExecutorImpl() throws Exception {
        this.connection = DriverManager.getConnection(URL);
        this.connection.setAutoCommit(false);
        PreparedStatement pst = connection.prepareStatement
                ("create table user (id bigint(20) NOT NULL auto_increment, " +
                        "name varchar(255), age int(3))");
        System.out.println(pst);
        pst.executeUpdate();
        pst.close();


    }

    @Override
    public void save(Object objectData) throws Exception {
        this.reflection = new Reflection(objectData);
        this.data = reflection.getResult();
        System.out.println(data);
        PreparedStatement sv = connection.prepareStatement("insert into user (id, name, age) values (?,?,?)");
        sv.setString(1, data.get("id"));
        sv.setString(2, data.get("name"));
        sv.setString(3, data.get("age"));
        System.out.println(sv);
        sv.executeUpdate();
        sv.close();
    }


    @Override
    public Object load(long id, Class clazz) throws Exception {
        long i = 0;
        String name = null;
        int age = 0;

        PreparedStatement sel = connection.prepareStatement("Select * from user where id = ?");
        sel.setString(1, Long.toString(id));
        ResultSet resultSet = sel.executeQuery();
        System.out.println(resultSet);
        while (resultSet.next()) {
            i = resultSet.getInt(1);
            name = resultSet.getString(2);
            age = resultSet.getInt(3);

        }
        resultSet.close();
        sel.close();
        if (id < 1) {
            throw new Exception(new IdException("Что-то пошло не так =("));
        }


        return "id: " + i + "\nName: " + name + "\nAge: " + age;
    }
}

