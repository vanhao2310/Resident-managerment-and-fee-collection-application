package com.manager.payment_manager.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HoKhauService {
    public static boolean checkIdHoExists(int idHo) {
        boolean isDuplicate = true;

        try (Connection conn = Utils.getConnection()) {
            String query = "SELECT COUNT(*) FROM HoKhau WHERE ID_HO = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, idHo);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                if (count > 0) {
                    isDuplicate = false;
                }
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isDuplicate;
    }
}
