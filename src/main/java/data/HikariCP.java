/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.*;

/**
 *
 * @author phatn
 */
public class HikariCP {
    private static HikariCP instance;
    
    private static HikariDataSource ds;
    
    private static final String URL =
            "jdbc:mysql://127.0.0.1:3306/DatabaseTest";

    private static final String USER = "root";

    private static final String PASSWORD = "123456";
    
    private HikariCP() {
        HikariConfig config = new HikariConfig();

        config.setJdbcUrl(URL);
        config.setUsername(USER);
        config.setPassword(PASSWORD);
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");

        HikariDataSource dataSource =
                new HikariDataSource(config);
        
        ds = dataSource;
    }
    
    public static HikariCP getInstance(){
        if (instance == null){
            synchronized(HikariCP.class){
                if (instance == null){
                    instance = new HikariCP();
                }
            }
        }
        return instance;
    }
    
    public Connection getConnection() throws SQLException{
        return ds.getConnection();
    }
    
    public void freeConnection(Connection conn) {
        try{
            conn.close();
        }
        catch (SQLException e){
            System.out.println(e);
        }
    }
}
