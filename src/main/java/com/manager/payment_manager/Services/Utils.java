package com.manager.payment_manager.Services;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Utils {
    static final String url = "jdbc:mysql://localhost:3306/qlydancu";
    static final String user = "root";
    static final String password = "nhatduc123";  //fix this


    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

}
