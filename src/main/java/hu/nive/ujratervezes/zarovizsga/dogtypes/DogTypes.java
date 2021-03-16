package hu.nive.ujratervezes.zarovizsga.dogtypes;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DogTypes {

    private final DataSource dataSource;

    public DogTypes(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getDogsByCountry(String country) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement statement =
                     conn.prepareStatement("SELECT LOWER(name) AS name FROM dog_types WHERE country LIKE ?")) {
            statement.setString(1, country.toLowerCase());

            return getResult(statement);
        } catch (SQLException se) {
            throw new IllegalStateException("Can't prepared SELECT", se);
        }
    }

    private List<String> getResult(PreparedStatement statement) {
        try (ResultSet rs = statement.executeQuery()) {
            List<String> dogs = new ArrayList<>();
            while (rs.next()) {
                String name = rs.getString("name");
                dogs.add(name);
            }
            return dogs;
        } catch (SQLException se) {
            throw new IllegalStateException("Can't prepared SELECT", se);
        }
    }
}
