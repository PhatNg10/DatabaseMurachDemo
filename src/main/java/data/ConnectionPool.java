package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {

    private static ConnectionPool instance;

    private final List<Connection> pool = new ArrayList<>();

    private static final int POOL_SIZE = 3;

    private static final String URL =
            "jdbc:mysql://127.0.0.1:3306/DatabaseTest";

    private static final String USER = "root";

    private static final String PASSWORD = "123456";

    private ConnectionPool() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            for (int i = 0; i < POOL_SIZE; i++) {

                Connection connection =
                        DriverManager.getConnection(
                                URL,
                                USER,
                                PASSWORD
                        );

                pool.add(connection);
            }

            System.out.println(
                    "Connection pool created: " + pool.size()
            );

        } catch (ClassNotFoundException | SQLException e) {

            System.out.println(
                    "Cannot create connection pool!"
            );

            e.printStackTrace();

            throw new RuntimeException(e);
        }
    }

    public static synchronized ConnectionPool getInstance() {

        if (instance == null) {
            instance = new ConnectionPool();
        }

        return instance;
    }

    public synchronized Connection getConnection() {

        if (pool.isEmpty()) {
            throw new RuntimeException(
                    "Connection pool is empty!"
            );
        }

        return pool.remove(0);
    }

    public synchronized void freeConnection(
            Connection connection) {

        if (connection != null) {
            pool.add(connection);
        }
    }
}