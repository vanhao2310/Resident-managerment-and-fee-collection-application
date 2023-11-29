package com.manager.payment_manager.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckLoginService {
    public static boolean checkLogin(String username, String password, String role){
        try(Connection conn = Utils.getConnection()){
            String q = "select exists (select * from user_account where user_name = ? and user_password = ? and user_role = ?)";
            PreparedStatement pst = conn.prepareStatement(q);
            pst.setString(1, username);
            pst.setString(2, password);
            pst.setString(3, role);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                if(rs.getInt(1) == 1){
                    return true;
                }else {
                    System.out.println("Wrong username or password");
                    return false;
                }
            }
            return false;

        }catch (SQLException e){
            System.out.println("Connection failed in check login service");
            System.out.println(e.getMessage());
        }
        return false;
    }
}
