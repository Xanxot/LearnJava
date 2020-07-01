package DBService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Optional;
import java.util.function.Function;

public class Executor {
    private final Connection connection;

    public Executor(Connection connection) {
        this.connection = connection;
    }

    public void insert(String query, HashMap<String, String> data) {
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

    public void update(String query) {
        try (PreparedStatement upd = connection.prepareStatement(query)) {
            int resultSet = upd.executeUpdate();

        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    public int count(String query) {
        //todo: this shit String.format()

        try (PreparedStatement sel = connection.prepareStatement(query)) {
            ResultSet resultSet = sel.executeQuery();
            resultSet.last();

            int count = resultSet.getInt(1);
            return count;

        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    public <T> Optional<T> select(String sql, long id, Function<ResultSet, T> rsHandler) {
        try (PreparedStatement sel = connection.prepareStatement(sql)) {
            sel.setLong(1, id);
            ResultSet resultSet = sel.executeQuery();
            return Optional.ofNullable(rsHandler.apply(resultSet));
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }
}
