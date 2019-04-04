/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Model.Flight;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class FlightDAO extends DataConfig {

    public ArrayList<Flight> getFlight(int from, int to, Date date) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Flight> list = new ArrayList<>();
        try {
            conn = this.getConnection();
            String sql = "  SELECT * FROM dbo.FlightTime WHERE fromCity = ? AND toCity = ? AND dateFlight=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, from);
            pstmt.setInt(2, to);
            pstmt.setDate(3, date);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Flight ob = new Flight();
                ob.setID(rs.getInt("ID"));
                ob.setFromCity(rs.getString("fromCity"));
                ob.setToCity(rs.getString("toCity"));
                ob.setDepart(rs.getString("depart"));
                ob.setArrival(rs.getString("Arrival"));
                ob.setDateFlight(rs.getDate("dateFlight"));
                ob.setPrice(rs.getFloat("price"));
                ob.setRoundTime(rs.getString("roundTime"));
                list.add(ob);
            }
        } catch (Exception e) {
            throw e;
        }
        return list;
    }

    public Flight getFlightByID(int ID) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Flight> list = new ArrayList<>();
          Flight ob = null;
        try {
            conn = this.getConnection();
            String sql = "  SELECT * FROM dbo.FlightTime WHERE ID=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, ID);
           
            rs = pstmt.executeQuery();
            if (rs.next()) {
                ob = new Flight();
                ob.setID(rs.getInt("ID"));
                ob.setFromCity(rs.getString("fromCity"));
                ob.setToCity(rs.getString("toCity"));
                ob.setDepart(rs.getString("depart"));
                ob.setArrival(rs.getString("Arrival"));
                ob.setDateFlight(rs.getDate("dateFlight"));
                ob.setPrice(rs.getFloat("price"));
                ob.setRoundTime(rs.getString("roundTime"));
                list.add(ob);
            }
        } catch (Exception e) {
            throw e;
        }
        return ob;
    }

}
