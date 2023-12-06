package com.manager.payment_manager.config;

import com.manager.payment_manager.Services.Utils;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class UtilsTest {
    private static Connection connection;

    @Test
    public void beforeAll() throws SQLException {
        connection = Utils.getConnection();
        if(connection == null)
            System.out.println("Connection failed");
        else
            System.out.println("Connection success");
    }

    @Test
    public void afterAll() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    @Test
    public void testQuantity() throws SQLException {
        PreparedStatement pst = connection.prepareStatement("select * from HoKhau limit 10");
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getInt("ID_HO") + rs.getString("chu_ho") + rs.getString("dia_chi") + rs.getInt("so_thanh_vien") + "\n");
        }
        pst.close();
    }
}
