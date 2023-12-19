package com.manager.payment_manager.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FeeService {
    public static List<String> getAllFeeName() {
        List<String> result = new ArrayList<>();
        try (Connection conn = Utils.getConnection()) {
            PreparedStatement pst = conn.prepareStatement("select ten from Khoan_thu");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                result.add(rs.getString("ten"));
            }
        } catch (SQLException e) {
            System.out.println("Can not query feeName");
            System.out.println(e.getMessage());
        }
        return result;
    }
    public static int phaseMax(String feeName) {
        int result = 1;
        try (Connection conn = Utils.getConnection()) {
            PreparedStatement pst = conn.prepareStatement(
                "select max(dot_nop) from Khoan_thu_log, Khoan_thu where Khoan_thu_log.id_khoan_thu = Khoan_thu.id_khoan_thu AND Khoan_thu.ten LIKE ?");
            pst.setString(1, feeName);
            ResultSet rs = pst.executeQuery();

            while (rs.next())
                result = rs.getInt(1);
            rs.close();
            pst.close();
        } catch (SQLException e) {
            System.out.println("Can not query phase");
            System.out.println(e.getMessage());
        }
        return result;
    }

}
