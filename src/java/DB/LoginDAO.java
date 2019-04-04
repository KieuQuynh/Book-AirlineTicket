/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author admin
 */
public class LoginDAO extends DataConfig {

    public User getUser(String email) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        User ob = null;
        try {
            String sql = "SELECT * FROM dbo.Users WHERE email = ?";
            conn = this.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            ob = new User();
            rs = pstmt.executeQuery();
            if (rs.next()) {
                ob.setEmail(rs.getString("email"));
                ob.setPassword(rs.getString("password"));
                ob.setFirstName(rs.getString("firstName"));
                ob.setLastName(rs.getString("lastName"));
                ob.setPhone(rs.getString("phone"));
                ob.setAddress(rs.getString("address"));
                ob.setAge(rs.getInt("age"));
                ob.setCardNumber(rs.getString("cardNumber"));
                ob.setSex(rs.getBoolean("sex"));
                ob.setID(rs.getInt("ID"));
            }

        } catch (Exception e) {
            throw e;
        }

        this.close(conn, pstmt, rs);
        return ob;

    }
    
    public User getUserByID(int ID) throws Exception{
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        User ob = null;
        try {
            String sql = "SELECT * FROM dbo.Users WHERE ID = ?";
            conn = this.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, ID);
            ob = new User();
            rs = pstmt.executeQuery();
            if (rs.next()) {
                ob.setEmail(rs.getString("email"));
                ob.setPassword(rs.getString("password"));
                ob.setFirstName(rs.getString("firstName"));
                ob.setLastName(rs.getString("lastName"));
                ob.setPhone(rs.getString("phone"));
                ob.setAddress(rs.getString("address"));
                ob.setAge(rs.getInt("age"));
                ob.setCardNumber(rs.getString("cardNumber"));
                ob.setSex(rs.getBoolean("sex"));
                ob.setID(rs.getInt("ID"));
            }

        } catch (Exception e) {
            throw e;
        }

        this.close(conn, pstmt, rs);
        return ob;

    }
    
    
    public boolean checkEmailExist(String email ) throws Exception{
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs =null;
        boolean f=false;
        try {
            String sql = "SELECT * FROM dbo.Users WHERE Email = ?";
            conn = this.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            
            rs = pstmt.executeQuery();
            if (rs.next()) {
               f= true;
            }

        } catch (Exception e) {
            throw e;
        }

        this.close(conn, pstmt, rs);
        return f;
    }
    
    public void insertUser(User ob ) throws Exception{
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
      
        try {
            String sql = "INSERT INTO dbo.Users( email ,  password , firstname ,lastname , address , phone , sex , cardNumber , age )\n" +
                         "VALUES  (?,?,?,?,?,?,?,?,?)";
            conn = this.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, ob.getEmail());
            pstmt.setString(2, ob.getPassword());
            pstmt.setString(3, ob.getFirstName());
            pstmt.setString(4, ob.getLastName());
            pstmt.setString(5, ob.getAddress());
            pstmt.setString(6, ob.getPhone());
            pstmt.setBoolean(7, ob.isSex());
            pstmt.setString(8, ob.getCardNumber());
            pstmt.setInt(9, ob.getAge());
            
            pstmt.executeUpdate();
        } catch (Exception e) {
            throw e;
        }

        this.close(conn, pstmt, rs);
       
    }
    
}
