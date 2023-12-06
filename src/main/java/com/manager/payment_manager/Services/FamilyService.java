package com.manager.payment_manager.Services;

import com.manager.payment_manager.Models.Family;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
* Table: hokhau
* Columns:
* ID_HO int AI PK
* chu_ho varchar(100)
* dia_chi varchar(100)
* so_thanh_vien int
* */

public class FamilyService {

    // TODO: Get all families
    public static List<Family> getAllFamily() {
        List<Family> result = new ArrayList<>();
        try (Connection connection = Utils.getConnection()) {
            PreparedStatement pst = connection.prepareStatement("select * from HoKhau");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Family family = new Family( rs.getInt("ID_HO"),
                                            rs.getString("chu_ho"),
                                            rs.getString("dia_chi"),
                                            rs.getInt("so_thanh_vien"));
                result.add(family);
            }
            rs.close();
            pst.close();
        } catch (SQLException e) {
            System.out.println("Can not query family");
            System.out.println(e.getMessage());
        }
        return result;
    }
}
