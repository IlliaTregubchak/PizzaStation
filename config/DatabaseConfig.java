package station.pizza.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static station.pizza.util.Constants.*;

public class DatabaseConfig {

    public static Connection connection;

    public static void connect() {
        try{
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch(SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void close() {
        try{
            connection.close();
        } catch(SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
