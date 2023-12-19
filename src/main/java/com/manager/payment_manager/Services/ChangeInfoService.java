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

    public static void addChangeInfor(List<ChangeInfo> listChange){
        try(Connection conn = Utils.getConnection()){
            String sql = "insert into data_log (loai, ten_loai, ID_NGUOI, ghi_chu, ngay_thay_doi) values (?, ?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            for(ChangeInfo changeInfo : listChange){
                pst.setInt(1, changeInfo.getLoai());
                pst.setString(2, changeInfo.getTen_loai());
                pst.setInt(3, changeInfo.getID_nguoi());
                pst.setString(4, changeInfo.getGhi_chu());
                pst.setDate(5, changeInfo.getNgay_thay_doi());
                pst.executeUpdate();
            }
            pst.close();
        }catch(SQLException e){
            System.out.println("Exeption in ChangeInfoService addChangeInfor");
            System.out.println(e.getMessage());
        }
    }

    public static void addChangeInfor(ChangeInfo changeInfor){
        try(Connection conn = Utils.getConnection()){
            String sql = "insert into data_log (loai, ten_loai, ID_NGUOI, ghi_chu, ngay_thay_doi) values (?, ?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
                pst.setInt(1, changeInfor.getLoai());
                pst.setString(2, changeInfor.getTen_loai());
                pst.setInt(3, changeInfor.getID_nguoi());
                pst.setString(4, changeInfor.getGhi_chu());
                pst.setDate(5, changeInfor.getNgay_thay_doi());
                pst.executeUpdate();
            pst.close();
        }catch(SQLException e){
            System.out.println("Exeption in ChangeInfoService addChangeInfor");
            System.out.println(e.getMessage());
        }
    }
}
