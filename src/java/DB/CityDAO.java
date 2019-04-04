/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Model.City;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class CityDAO extends DataConfig {

    public ArrayList<City> getAllCities(String id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<City> list = new ArrayList<>();
        try {
            String sql = " SELECT * FROM  dbo.City WHERE 1=1";
            conn = this.getConnection();

            if (id != null) {
                sql += " and id not in (?)";
            }
            pstmt = conn.prepareStatement(sql);
            if (id != null) {
                pstmt.setInt(1, Integer.parseInt(id));
            }
            rs = pstmt.executeQuery();
            while (rs.next()) {
                City ob = new City();
                ob.setID(rs.getInt("id"));
                ob.setName(rs.getString("name"));
                list.add(ob);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CityDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.close(conn, pstmt, rs);
        }
        return list;
    }

    public City getCity(int id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<City> list = new ArrayList<>();
        City ob = null;
        try {
            String sql = " SELECT * FROM  dbo.City WHERE id=?";
            conn = this.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                ob = new City();
                ob.setID(rs.getInt("id"));
                ob.setName(rs.getString("name"));
                list.add(ob);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CityDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.close(conn, pstmt, rs);
        }
        return ob;
    }
}
