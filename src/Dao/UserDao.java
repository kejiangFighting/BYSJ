package Dao;

import Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public User signin (Connection con, User user) throws SQLException{
        User resultUser = null;
        PreparedStatement pstmt = null;
        try {
            String sql = "select * from user where userID=? and password=?";

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user.getUserID());
            pstmt.setString(2, user.getPassword());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
                resultUser = new User();
                resultUser.setEmail(rs.getString("email"));
                resultUser.setPassword(rs.getString("password"));
                resultUser.setRole(rs.getInt("role"));
                resultUser.setName(rs.getString("name"));
                resultUser.setCollege(rs.getString("college"));
                resultUser.setMajor(rs.getString("major"));
                resultUser.setUserID(rs.getString("userID"));
                resultUser.setTeam(rs.getString("team"));
                resultUser.setPhone(rs.getString("phone"));
                        
            }

            return resultUser;
        }catch (Exception e){
            e.printStackTrace();
        }
        return resultUser;
    }
}
