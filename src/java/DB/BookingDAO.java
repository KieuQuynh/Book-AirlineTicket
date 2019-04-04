/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Model.Booking;
import Model.Flight;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.spi.DirStateFactory.Result;

/**
 *
 * @author admin
 */
public class BookingDAO extends DataConfig {

    public void bookingTicketOneTrip(int userID, String reservationCode, String timeBooking, int flightID) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = " INSERT INTO dbo.booking( reservationCode , userID , flight1ID , timeBook)\n"
                    + " VALUES  (?,?,?,?)";
            conn = this.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, reservationCode);
            pstmt.setInt(2, userID);
            pstmt.setInt(3, flightID);
            pstmt.setString(4, timeBooking);

            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CityDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.close(conn, pstmt, rs);
        }

    }

    public void bookingTicketRoundTrip(int userID, String reservationCode, String timeBooking, int flight1ID, int flight2ID) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = " INSERT INTO dbo.booking( reservationCode , userID , flight1ID ,flight2ID, timeBook)\n"
                    + " VALUES  (?,?,?,?,?)";
            conn = this.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, reservationCode);
            pstmt.setInt(2, userID);
            pstmt.setInt(3, flight1ID);
            pstmt.setInt(4, flight2ID);
            pstmt.setString(5, timeBooking);

            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CityDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.close(conn, pstmt, rs);
        }

    }

    public boolean getFlightbyReservatioCode(String code) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean f = true;
        try {
            String sql = " SELECT * FROM dbo.booking WHERE reservationCode = ?";
            conn = this.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, code);
            rs = pstmt.executeQuery();
            Booking ob = new Booking();
            if (rs.next()) {
                f = false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(CityDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.close(conn, pstmt, rs);
        }
        return f;
    }

    public ArrayList<Booking> getAllFlights(int pageIndex, int pageSize) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Booking> list = new ArrayList<>();
        int startIndex = (pageIndex - 1) * pageSize + 1;
        int endIndex = pageIndex * pageSize;
        try {
            String sql = "  select * FROM (  select ROW_NUMBER() over (order by dbo.booking.bookID DESC)\n"
                    + " as rn, * FROM dbo.booking ) AS x WHERE rn between ?  and ?";

            conn = this.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, startIndex);
            pstmt.setInt(2, endIndex);

            rs = pstmt.executeQuery();
            while (rs.next()) {

                Booking ob = new Booking();
                ob.setID(rs.getInt("bookID"));
                ob.setFlight1ID(rs.getInt("Flight1ID"));
                ob.setFlight2ID(rs.getInt("Flight2ID"));
                ob.setReservationCode(rs.getString("reservationCode"));
                ob.setTimeBook(rs.getString("timeBook"));
                ob.setUserID(rs.getInt("userID"));
                list.add(ob);
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            this.close(conn, pstmt, rs);
        }
        return list;
    }

    public ArrayList<Booking> getFlightByRC(String code) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Booking> list = new ArrayList<>();

        try {
            String sql = "SELECT * FROM dbo.booking WHERE reservationCode = ?";
            conn = this.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, code);
            rs = pstmt.executeQuery();
            while (rs.next()) {

                Booking ob = new Booking();
                ob.setID(rs.getInt("bookID"));
                ob.setFlight1ID(rs.getInt("Flight1ID"));
                ob.setFlight2ID(rs.getInt("Flight2ID"));
                ob.setReservationCode(rs.getString("reservationCode"));
                ob.setTimeBook(rs.getString("timeBook"));
                ob.setUserID(rs.getInt("userID"));
                list.add(ob);
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            this.close(conn, pstmt, rs);
        }
        return list;

    }
    
      public int getTotalBooking() throws Exception{
         String sql=" SELECT COUNT(*)  AS Total FROM dbo.Booking";
         Connection conn = this.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql);
         ResultSet rs= pstmt.executeQuery();
         int total=0;
         if(rs.next()){
             total = rs.getInt("Total");
         }
         this.close(conn, pstmt, rs);
         return total;
     }
}
