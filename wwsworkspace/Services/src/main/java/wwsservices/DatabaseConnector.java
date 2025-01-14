package wwsservices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private static DatabaseConnector INSTANCE;
    private Connection connection;
    private String url = "jdbc:sqlite:data/fswi-wws-sqlite.sqlite";

    private DatabaseConnector() {
        try {
            this.connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DatabaseConnector getInstance() {
        if (INSTANCE == null) {
            synchronized (DatabaseConnector.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DatabaseConnector();
                }
            }
        }
        return INSTANCE;
    }

    public Connection getConnection() {
        return connection;
    }
}
