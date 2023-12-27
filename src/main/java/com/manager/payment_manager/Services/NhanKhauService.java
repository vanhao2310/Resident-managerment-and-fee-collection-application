package com.manager.payment_manager.Services;

import com.manager.payment_manager.Models.NhanKhau;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                nk.setTrangThai(rs.getString("trang_thai"));
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
            String sql = "insert into NHANKHAU (ID_HO, ho_ten, ngay_sinh, gioi_tinh, dan_toc, nghe_nghiep, nguyen_quan, noi_sinh, noi_lam_viec, CCCD, ngay_cap_CCCD, noi_cap_CCCD, dia_chi_cu, bi_danh, trang_thai) " +
                    "value (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, nhankhau.getIdHo());
            pst.setString(2, nhankhau.getHoTen());
            pst.setDate(3, nhankhau.getNgaySinh());
            pst.setString(4, nhankhau.getGioiTinh());
            pst.setString(5, nhankhau.getDanToc());
            pst.setString(6, nhankhau.getNgheNghiep());
            pst.setString(7, nhankhau.getNguyenQuan());
            pst.setString(8, nhankhau.getNoiSinh());
            pst.setString(9, nhankhau.getNoiLamViec());
            pst.setString(10, nhankhau.getCCCD());
            pst.setDate(11, nhankhau.getNgayCap());
            pst.setString(12, nhankhau.getNoiCap());
            pst.setString(13, nhankhau.getDiaChiTruoc());
            pst.setString(14, nhankhau.getBiDanh());
            pst.setString(15, "Thường trú");
            pst.executeUpdate();

            pst.close();
        }catch(SQLException e){
            System.out.println("Error in Insert Nhan Khau to database");
            System.out.println(e.getMessage());
        }
    }
// ID_HO, ho_ten, ngay_sinh, gioi_tinh, dan_toc,
// nghe_nghiep, nguyen_quan, noi_sinh, noi_lam_viec,
// CCCD, ngay_cap_CCCD, noi_cap_CCCD, dia_chi_cu, bi_danh
    public static void updateNhanKhau(NhanKhau nhanKhau) {
        try (Connection conn = Utils.getConnection()) {
            String sql = "update NHANKHAU set " +
                    "ho_ten = ?," +
                    "ngay_sinh = ?," +
                    "gioi_tinh = ?," +
                    "dan_toc = ?," +
                    "nghe_nghiep = ?," +
                    "nguyen_quan = ?," +
                    "noi_sinh = ?," +
                    "noi_lam_viec = ?," +
                    "CCCD = ?," +
                    "ngay_cap_CCCD = ?," +
                    "noi_cap_CCCD = ?," +
                    "dia_chi_cu = ?," +
                    "bi_danh = ?, " +
                    "trang_thai = ? " +
                    "where ID_NGUOI = ?;";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, nhanKhau.getHoTen());
            pst.setDate(2, nhanKhau.getNgaySinh());
            pst.setString(3, nhanKhau.getGioiTinh());
            pst.setString(4, nhanKhau.getDanToc());
            pst.setString(5, nhanKhau.getNgheNghiep());
            pst.setString(6, nhanKhau.getNguyenQuan());
            pst.setString(7, nhanKhau.getNoiSinh());
            pst.setString(8, nhanKhau.getNoiLamViec());
            pst.setString(9, nhanKhau.getCCCD());
            pst.setDate(10, nhanKhau.getNgayCap());
            pst.setString(11, nhanKhau.getNoiCap());
            pst.setString(12, nhanKhau.getDiaChiTruoc());
            pst.setString(13, nhanKhau.getBiDanh());
            pst.setString(14, nhanKhau.getTrangThai());
            pst.setString(15, nhanKhau.getId());

            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static NhanKhau getThongTinNhanKhau(String idNhanKhau){
        NhanKhau result = null;
        try (Connection conn = Utils.getConnection()){
            String sql = "select * from nhankhau where ID_NGUOI = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, idNhanKhau);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                result = new NhanKhau(rs.getInt("ID_Nguoi"), rs.getString("ho_ten"),
                        rs.getString("bi_danh"), rs.getDate("ngay_sinh"), rs.getString("gioi_tinh"), rs.getString("vai_tro"), rs.getString("noi_sinh"),
                        rs.getString("nguyen_quan"), rs.getString("dan_toc"),
                        rs.getString("nghe_nghiep"), rs.getString("noi_lam_viec"), rs.getString("CCCD"),
                        rs.getDate("ngay_cap_CCCD"), rs.getString("noi_cap_CCCD"), rs.getDate("date_thuong_tru"),
                        rs.getString("dia_chi_cu"), rs.getInt("ID_HO"));
                result.setTrangThai(rs.getString("trang_thai"));
            }
            rs.close();
            pst.close();
        } catch (SQLException e){
            System.out.println("Exception in NhanKhauService getNhanKhau");
            System.out.println(e.getMessage());
        }
        return result;
    }
    public static void deleteNhanKhau(String idNguoi) {
        try (Connection conn = Utils.getConnection()) {
            String sql = "Delete from nhankhau WHERE ID_Nguoi = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, idNguoi);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            System.out.println("Exception in NhanKhauService deleteNhanKhau");
            System.out.println(e.getMessage());
        }
    }

    public static int maleCount() {
        int result = 0;
        try (Connection conn = Utils.getConnection()) {
            PreparedStatement pst = conn.prepareStatement("select count(ID_NGUOI) from nhankhau where gioi_tinh = 'Nam'");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                result = rs.getInt(1);
            }
            rs.close();
            pst.close();
        } catch (SQLException e) {
            System.out.println("Exception in maleCount");
            System.out.println(e.getMessage());
        }
        return result;
    }

    public static int femaleCount() {
        int result = 0;
        try (Connection conn = Utils.getConnection()) {
            PreparedStatement pst = conn.prepareStatement("select count(ID_NGUOI) from nhankhau where gioi_tinh = 'Nữ'");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                result = rs.getInt(1);
            }
            rs.close();
            pst.close();
        } catch (SQLException e) {
            System.out.println("Exception in maleCount");
            System.out.println(e.getMessage());
        }
        return result;
    }

    public static int ageRangeCount(int start, int end) {
        int result = 0;
        try (Connection conn = Utils.getConnection()) {
            PreparedStatement pst = conn.prepareStatement("select count(ID_NGUOI) from nhankhau where YEAR(CURDATE()) - YEAR(ngay_sinh) BETWEEN ? AND ?");
            pst.setString(1, String.valueOf(start));
            pst.setString(2, String.valueOf(end));
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                result = rs.getInt(1);
            }
            rs.close();
            pst.close();
        } catch (SQLException e) {
            System.out.println("Can not query ageRange");
            System.out.println(e.getMessage());
        }
        return result;
    }

    public static void dispartFamily(List<Integer> members, int newIdHo) {
        try(Connection conn = Utils.getConnection()){
            String sql = "update nhankhau set ID_HO = ? where ID_NGUOI = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            for(int id : members){
                pst.setInt(1, newIdHo);
                pst.setInt(2, id);
                pst.executeUpdate();
            }
            pst.close();
        }catch(SQLException e){
            System.out.println("Exeption in NhanKhauService dispartFamily");
            System.out.println(e.getMessage());
        }
    }

    public static List<Integer> findByName(String name){
        List<Integer> result = new ArrayList<>();
        try(Connection conn = Utils.getConnection()){
            String sql = "select * from nhankhau where ho_ten like ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + name.trim() + "%");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                result.add(rs.getInt("ID_NGUOI"));
            }
            rs.close();
            pst.close();
        }catch(SQLException e){
            System.out.println("Exeption in NhanKhauService findByName");
            System.out.println(e.getMessage());
        }
        return result;
    }

    public static int peopleCount(int month, int year) {
        int res = 0;
        try(Connection conn = Utils.getConnection()) {
            String date = year + "-" + month + "-28";
            String sql = "select COUNT(ID_NGUOI) from nhankhau where date_thuong_tru <= ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, date);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                res = rs.getInt(1);
            }
            rs.close();
            pst.close();
        } catch (SQLException e) {
            System.out.println("Can not count people");
            System.out.println(e.getMessage());
        }
        return res;
    }
}
