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

    public static Family getFamilyWithID(String id_ho) {
        Family result = null;
        try (Connection conn = Utils.getConnection()) {
            String sql = "select * from HoKhau where ID_HO = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id_ho);

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result = new Family(rs.getInt("ID_HO"),
                                    rs.getString("chu_ho"),
                                    rs.getString("dia_chi"),
                                    rs.getInt("so_thanh_vien"));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Can not query family");
            System.out.println(e.getMessage());
        }
        return result;
    }

    //add family to database
    public static void addFamily(Family family){
        try(Connection conn = Utils.getConnection()){
            String sql = "insert into HoKhau (chu_ho, dia_chi, so_thanh_vien) value (?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, family.getFamilyHead());
            pst.setString(2, family.getFamilyAddress());
            pst.setInt(3, family.getNumOfPeople());
            pst.executeUpdate();
            //
            pst.close();
        } catch (SQLException e){
            System.out.println("Error in insert family to database");
            System.out.println(e.getMessage());
        }
    }

    public static int getIdHo(String chuHo, String diaChi){
        int idHo = 0;
        try(Connection conn = Utils.getConnection()){
            String sql = "select ID_HO from HoKhau where chu_ho = ? and dia_chi = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, chuHo);
            pst.setString(2, diaChi);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                idHo = rs.getInt("ID_HO");
            }
            rs.close();
            pst.close();
        } catch (SQLException e){
            System.out.println("Error in get id ho");
            System.out.println(e.getMessage());
        }
        return idHo;
    }
}
