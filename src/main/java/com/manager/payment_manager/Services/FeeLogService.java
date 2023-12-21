package com.manager.payment_manager.Services;

import com.manager.payment_manager.Models.FeeLog;

import java.sql.*;

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
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
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
            e.printStackTrace();
        }

        return isDuplicate;
    }
}
