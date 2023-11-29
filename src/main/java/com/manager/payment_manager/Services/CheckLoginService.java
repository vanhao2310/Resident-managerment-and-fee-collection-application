package com.manager.payment_manager.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CheckLoginService {
    public static boolean checkLogin(String username, String password, String role){
        try(Connection conn = Utils.getConnection()){
            String q = "select exists (select * from user_account where username = ? and password = ? and role = ?)";
            PreparedStatement pst = conn.prepareStatement(q);
            pst.setString(1, username);
            pst.setString(2, password);
            pst.setString(3, role);
            return pst.executeQuery().getBoolean(1);
        }catch (SQLException e){
            System.out.println("Connection failed in check login service");
            System.out.println(e.getMessage());
        }
        return false;
    }
}
