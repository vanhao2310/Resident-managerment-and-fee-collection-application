package com.manager.payment_manager.Services;

import com.manager.payment_manager.Models.Fee;
import com.manager.payment_manager.Models.FeeLog;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FeeLogService {
    public static void addKhoanThuHo(FeeLog feelog){
        try(Connection conn = Utils.getConnection()){
            String sql = "insert into Khoan_thu_log (ID_HO, id_khoan_thu, so_tien, dot_nop, ngay_nop) " +
                    "value (?, ?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, feelog.getHoId());
            pst.setInt(2, feelog.getKhoanThuId());
            pst.setInt(3, feelog.getSoTien());
            pst.setInt(4, feelog.getDotNop());
            pst.setDate(5, feelog.getNgayNop());
            pst.executeUpdate();

            pst.close();
        }catch(SQLException e){
            System.out.println("Error in Insert Khoan Thu Ho to database");
            System.out.println(e.getMessage());
        }
    }

    // TODO: Lấy tất cả log thuộc đợt phase_num của feeType
    public static List<FeeLog> getAllLog(String feeType, int phase_num) {
        List<FeeLog> result = new ArrayList<>();
        try (Connection conn = Utils.getConnection()) {
            int id_log = getIdKhoanThuFromKhoanThuLog(feeType);
            PreparedStatement pst = conn.prepareStatement("select * from Khoan_thu_log where id_khoan_thu = ? AND dot_nop = ?");
            pst.setInt(1, id_log);
            pst.setInt(2, phase_num);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                FeeLog feeLog = new FeeLog(rs.getInt("ID_HO"),
                                        rs.getInt("id_khoan_thu"),
                                        rs.getInt("so_tien"),
                                        rs.getInt("dot_nop"),
                                        rs.getDate("ngay_nop"));
                result.add(feeLog);
            }
            rs.close();
            pst.close();
        } catch (SQLException e) {
            System.out.println("Error in getAllLog");
            System.out.println(e.getMessage());
        }
        return result;
    }

    // TODO: Lấy id_khoan_thu từ tên
    public static int getIdKhoanThuFromKhoanThuLog(String ten) {
        int idKhoanThu = -1;

        try(Connection conn = Utils.getConnection()) {
            String query = "SELECT ktlog.id_khoan_thu " +
                    "FROM Khoan_thu_log ktlog " +
                    "JOIN Khoan_thu kt ON ktlog.id_khoan_thu = kt.id_khoan_thu " +
                    "WHERE kt.ten = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, ten);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                idKhoanThu = rs.getInt("id_khoan_thu");
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return idKhoanThu;
    }

    public static boolean checkDuplicate(int hoId, int khoanThuId) {
        boolean isDuplicate = false;

        try (Connection conn = Utils.getConnection()) {
            String query = "SELECT COUNT(*) FROM Khoan_thu_log WHERE ID_HO = ? AND id_khoan_thu = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, hoId);
            stmt.setInt(2, khoanThuId);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                if (count > 0) {
                    isDuplicate = true;
                }
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return isDuplicate;
    }

    //TODO: Lấy danh sách các hộ đóng khoản phí theo đợt trong phần thống kê
    public static List<FeeLog> getListFamilyWithPhase(int feeId, int phase){
        List<FeeLog> result = new ArrayList<>();
        try(Connection conn = Utils.getConnection()){
            String sql = "select ktl.id_ho, ktl.id_khoan_thu, ktl.so_tien, ktl.dot_nop, hk.chu_ho, hk.dia_chi " +
                    "from khoan_thu_log as ktl, HOKHAU as hk " +
                    "where ktl.id_khoan_thu = ? and ktl.dot_nop = ? AND ktl.ID_HO = hk.ID_HO";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, feeId);
            pst.setInt(2, phase);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                result.add(new FeeLog(rs.getInt("id_ho"), rs.getInt("id_khoan_thu"), rs.getInt("so_tien"),
                        rs.getInt("dot_nop"), rs.getString("chu_ho"), rs.getString("dia_chi")));
            }
        }catch(SQLException e){
            System.out.println("Error in getListFamilyWithPhase in FeeLogService!");
            System.out.println(e.getMessage());
        }
        return result;
    }


    // TODO: Kiểm tra xem nhà này đã đóng phí này đợt này chưa
    public static boolean checkSubmit(int id_ho, int id_khoan_thu, int dot_nop) {
        boolean res = false;
        if (dot_nop != 0) {
            try (Connection conn = Utils.getConnection()) {
                PreparedStatement pst = conn.prepareStatement("select so_tien from Khoan_thu_log where ID_HO = ? AND id_khoan_thu = ? AND dot_nop = ?");
                pst.setInt(1, id_ho);
                pst.setInt(2, id_khoan_thu);
                pst.setInt(3, dot_nop);

                ResultSet rs = pst.executeQuery();
                while(rs.next()) {
                    if (rs.getInt(1) != 0)
                        res = true;
                }
                rs.close();
                pst.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return res;
        }
        else {
            try (Connection conn = Utils.getConnection()) {
                PreparedStatement pst = conn.prepareStatement("select so_tien from Khoan_thu_log where ID_HO = ? AND id_khoan_thu = ?");
                pst.setInt(1, id_ho);
                pst.setInt(2, id_khoan_thu);

                ResultSet rs = pst.executeQuery();
                while(rs.next()) {
                    if (rs.getInt(1) != 0)
                        res = true;
                }
                rs.close();
                pst.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return res;
        }
    }
}
