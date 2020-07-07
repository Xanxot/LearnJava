package com.company.dbService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Optional;
import java.util.function.Function;

public class Executor {

    public void insert(String query, HashMap<String, String> data,Connection connection) {
        try (PreparedStatement sv = connection.prepareStatement(query)) {
            int cursor = 1;

            for (String value : data.values()) {
                sv.setString(cursor++, value);
            }
            sv.executeUpdate();
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);

        }
    }

    public void update(String query,Connection connection) {
        try (PreparedStatement upd = connection.prepareStatement(query)) {
            int resultSet = upd.executeUpdate();

        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    public int count(String query,Connection connection) {

        try (PreparedStatement sel = connection.prepareStatement(query)) {
            ResultSet resultSet = sel.executeQuery();
            resultSet.last();

            int count = resultSet.getInt(1);
            return count;

        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    public <T> Optional<T> select(String sql, long id, Function<ResultSet, T> rsHandler,Connection connection) {
        try (PreparedStatement sel = connection.prepareStatement(sql)) {
            sel.setLong(1, id);
            ResultSet resultSet = sel.executeQuery();
            return Optional.ofNullable(rsHandler.apply(resultSet));
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }
}
