
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DB.BookingDAO;
import DB.FlightDAO;
import DB.LoginDAO;
import Model.Booking;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author admin
 */
public class BookingController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            HttpSession session = request.getSession();
            String fighltID_Raw = request.getParameter("choose1");
            String flightID2_Raw = request.getParameter("choose2");
            String reservationCode = "";
            System.out.println("chooose1:"+fighltID_Raw);
             System.out.println("chooose2:"+flightID2_Raw );
            BookingDAO db = new BookingDAO();
            //userID
            int userID = Integer.parseInt(session.getAttribute("UserID").toString());

            //flightID
            int flightID = Integer.parseInt(request.getParameter("choose1"));
            int flightID2 = 0;
            
            if (flightID2_Raw != null) {
                flightID2 = Integer.parseInt(flightID2_Raw);
            }
            //timebooking
            Date d = new Date();

            //reservation code
            do {
                reservationCode = randomString();
            } while (!db.getFlightbyReservatioCode(reservationCode));
            request.setAttribute("code", reservationCode);
           

            if (flightID2_Raw != null) {
                db.bookingTicketRoundTrip(userID, reservationCode, d.toString(), flightID, flightID2);
            }
            else db.bookingTicketOneTrip(userID, reservationCode, d.toString(), flightID);

            FlightDAO db2 = new FlightDAO();
            LoginDAO db3 = new LoginDAO();
            ArrayList< Booking > list =db.getFlightByRC(reservationCode);
            HashMap<String ,ArrayList<Object>> map = new HashMap<>();
            for(Booking s :list){
                ArrayList<Object> ds = new ArrayList<>();
                ds.add(db3.getUserByID(s.getUserID()));
                ds.add(db2.getFlightByID(s.getFlight1ID()));
                ds.add(db2.getFlightByID(s.getFlight2ID()));
                ds.add(s.getTimeBook());
                map.put(s.getReservationCode(), ds);
            }
           
           
            request.setAttribute("active", "book");
            request.setAttribute("map", map);
            request.getRequestDispatcher("view/resultBooking.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(BookingController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(BookingController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String randomString() {
        String characters = "ABCDEFGHIJKLMOPQRSTXZ1234567890";
        String randomString = "";
        int length = 6;
        Random radom = new Random();
        for (int i = 0; i < length; i++) {
            int index = radom.nextInt(characters.length());
            randomString += characters.substring(index, index + 1);
        }
        return randomString;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
