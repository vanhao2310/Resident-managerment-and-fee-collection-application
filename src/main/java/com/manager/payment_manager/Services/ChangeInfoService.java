package com.manager.payment_manager.Services;

import com.manager.payment_manager.Models.ChangeInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChangeInfoService {

    public static List<ChangeInfo> getAllChangeInfo() {
        List<ChangeInfo> result = new ArrayList<>();
        try (Connection conn = Utils.getConnection()) {
            PreparedStatement pst = conn.prepareStatement("select * from data_log");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                ChangeInfo changeInfo = new ChangeInfo( rs.getInt("id"),
                                                        rs.getString("ten_loai"),
                                                        rs.getDate("ngay_thay_doi"));
                result.add(changeInfo);
            }
        } catch (SQLException e) {
            System.out.println("Can not query ChangeInfo");
            System.out.println(e.getMessage());
        }
        return result;
    }
}
