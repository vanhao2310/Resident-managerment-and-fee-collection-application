package com.manager.payment_manager.Services;

import com.manager.payment_manager.Models.NhanKhau;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class NhanKhauService {

    public static List<NhanKhau> getNhanKhau(String idHo){
        List<NhanKhau> dsNhanKhau = new ArrayList<>();
        try(Connection conn = Utils.getConnection()){
            String sql = "select * from nhankhau where ID_HO = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, idHo);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                NhanKhau nk = new NhanKhau(rs.getString("ID_Nguoi"), rs.getString("ho_ten"),
                        rs.getString("bi_danh"), rs.getDate("ngay_sinh"), rs.getString("noi_sinh"),
                        rs.getString("nguyen_quan"), rs.getString("dan_toc"),
                        rs.getString("nghe_nghiep"), rs.getString("noi_lam_viec"), rs.getString("CCCD"),
                        rs.getDate("ngay_cap_CCCD"), rs.getString("noi_cap_CCCD"), rs.getDate("date_thuong_tru"),
                        rs.getString("dia_chi_cu"));
                dsNhanKhau.add(nk);
            }
            rs.close();
            pst.close();
        }catch(SQLException e){
            System.out.println("Exeption in NhanKhauService getNhanKhau");
            e.printStackTrace();
        }
        return dsNhanKhau;
    }

    public static void addNhanKhau(NhanKhau nhankhau){
        try(Connection conn = Utils.getConnection()){
            String sql = "insert into nhankhau value ()";
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static NhanKhau getThongTinNhanKhau(String idNhanKhau){
        NhanKhau result = null;
        try(Connection conn = Utils.getConnection()){
            String sql = "select * from nhankhau where ID_NGUOI = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, idNhanKhau);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                result = new NhanKhau(rs.getString("ID_Nguoi"), rs.getString("ho_ten"),
                        rs.getString("bi_danh"), rs.getDate("ngay_sinh"), rs.getString("noi_sinh"),
                        rs.getString("nguyen_quan"), rs.getString("dan_toc"),
                        rs.getString("nghe_nghiep"), rs.getString("noi_lam_viec"), rs.getString("CCCD"),
                        rs.getDate("ngay_cap_CCCD"), rs.getString("noi_cap_CCCD"), rs.getDate("date_thuong_tru"),
                        rs.getString("dia_chi_cu"));
            }
            rs.close();
            pst.close();
        }catch(SQLException e){
            System.out.println("Exception in NhanKhauService getNhanKhau");
            System.out.println(e.getMessage());
        }
        return result;
    }
    public static void deleteNhanKhau(String idNguoi) {
        try (Connection conn = Utils.getConnection()) {
            String sql = "DELETE FROM nhankhau WHERE ID_Nguoi = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, idNguoi);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            System.out.println("Exception in NhanKhauService deleteNhanKhau");
            System.out.println(e.getMessage());
        }
    }
}
