package com.company.dbService;

import com.company.dbService.reflection.ReflectionHelpClass;
import com.company.IdException;
import com.company.id;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class DbServiceImpl<T> implements DbService<T> {
    Executor executor;
    Class annotation = id.class;
    private final Connection connection;

    public DbServiceImpl(DataSource dataSource) throws SQLException {
        this.executor = new Executor();
        this.connection = dataSource.getConnection();
    }


    @Override
    public void save(T objectData) throws Exception {

        boolean insertOrUpdate = insertOrUpdate(objectData);

        if (insertOrUpdate) {
            update(objectData);
        } else {
            insert(objectData);

        }
    }

    private void insert(T objectData) throws IllegalAccessException {
        HashMap<String, String> data = ReflectionHelpClass.getAllFieldsWithValues(objectData);

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

        String query = "insert into " + ReflectionHelpClass.getName(objectData.getClass()) + " " + keyBuilder + " values " + valueBuilder;

        executor.insert(query, data, connection);
    }

    private void update(T objectData) throws IllegalAccessException {
        HashMap<String, String> data = ReflectionHelpClass.getAllFieldsWithValues(objectData);
        List<String> keyList = new ArrayList<>(data.keySet());

        StringBuilder changeBuilder = new StringBuilder();
        StringBuilder changeLast = new StringBuilder(" where ");

        for (String s : keyList) {
            if (s.equals(annotation.getSimpleName())) {
                changeLast.append(s);
            } else {
                changeBuilder.append(s).append(" = ").append("'").append(data.get(s)).append("',");
            }
        }
        changeBuilder.setLength(changeBuilder.length() - 1);
        changeBuilder.append(changeLast);

        String query = "update " + ReflectionHelpClass.getName(objectData.getClass()) + " set " + changeBuilder + " = " + data.get(annotation.getSimpleName());
        executor.update(query, connection);
    }

    public boolean insertOrUpdate(T objectData) throws IllegalAccessException { //todo: query + stringFormat

        HashMap<String, String> primaryKey = ReflectionHelpClass.getPrimaryKeyWithValue(objectData, annotation);
        if (primaryKey.size() != 1) {
            throw new IdException("Не корректое количество @");
        }
        List<String> keyList = new ArrayList<>(primaryKey.keySet());
        String query = "Select count(*) from " + ReflectionHelpClass.getName(objectData.getClass()) + " where " + keyList.get(0) + " = " + primaryKey.get(annotation.getSimpleName());

        int count = executor.count(query, connection);
        return count != 0;
    }

    @Override
    public <T> T load(long id, Class<T> clazz) {
        String fromTable = ReflectionHelpClass.getName(clazz);
        String columnName = ReflectionHelpClass.getFieldsWithAnnotation(clazz, annotation)[0].getName();
        int countFields = ReflectionHelpClass.getFields(clazz).size();


        String query = String.format("select * from %s where %s  = ?", fromTable, columnName);
        Optional<T> user = executor.select(query, id, resultSet -> {
            try {
                Object[] objects = new Object[countFields];
                if (resultSet.next()) {
                    for (int i = 0; i < countFields; i++) {
                        objects[i] = resultSet.getObject(i + 1);
                    }
                }
                Object object = ReflectionHelpClass.instantiate(clazz, objects);
                return (T) object;

            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
            return null;
        }, connection);
        if (user != Optional.empty()) {
            return user.get();
        } else return null;


    }

    public void setAnnotation(Class annotation) {
        this.annotation = annotation;
    }

}