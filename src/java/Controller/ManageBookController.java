 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DB.BookingDAO;
import DB.DataConfig;
import DB.FlightDAO;
import DB.LoginDAO;
import Model.Booking;
import Pagger.Pagger;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
public class ManageBookController extends HttpServlet {

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
            
          try {
            String typeSearch= request.getParameter("typeSearch");
            String code="";
            ArrayList<Booking> list=null;
            BookingDAO db = new BookingDAO();
            if(typeSearch !=null && typeSearch.equals("one")) {
                 code= request.getParameter("code");
                 list =db.getFlightByRC(code);
            }
            else 
            if (typeSearch!= null && typeSearch.equals("all")){
                String result="";
                String pageRaw= request.getParameter("page");
                if(pageRaw==null) pageRaw="1";
                int pageGap = DataConfig.getPageGap();
                int totalBooking= db.getTotalBooking();
                int pageSize = DataConfig.getPageSize();
                int totalPage = totalBooking / pageSize + (totalBooking % pageSize == 0 ? 0 : 1);
                try {
                    int pageIndex = Integer.parseInt(pageRaw);
                    list =db.getAllFlights(pageIndex, pageSize);
                    if(pageIndex <=totalPage) {
                        String url= "?typeSearch=all&code=&page=";
                         result=Pagger.generate(pageIndex,pageSize,totalBooking,url,pageGap);
                    }
                    else result="No Results";
                } catch (Exception e) {
                     result="No Results";
                }
                request.setAttribute("pagger", result);
           }
            else {
                request.setAttribute("error", "true");
            }
            FlightDAO db2= new FlightDAO();
            LoginDAO db3= new LoginDAO();
         
            request.setAttribute("active", "manage");
            if(list!=null && list.size() >0) {
            HashMap<String ,ArrayList<Object>> map = new HashMap<>();
            for(Booking s :list){
                ArrayList<Object> ds = new ArrayList<>();
                ds.add(db3.getUserByID(s.getUserID()));
                ds.add(db2.getFlightByID(s.getFlight1ID()));
                ds.add(db2.getFlightByID(s.getFlight2ID()));
                ds.add(s.getTimeBook());
                map.put(s.getReservationCode(), ds);
            }
            request.setAttribute("map", map); }
            else {
                request.setAttribute("error", "true"); 
            }
             
            request.getRequestDispatcher("view/manageBooking.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ManageBookController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ManageBookController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            String typeSearch= request.getParameter("typeSearch");
            String code="";
            ArrayList<Booking> list=null;
            BookingDAO db = new BookingDAO();
            if(typeSearch.equals("one")) {
                 code= request.getParameter("code");
                 list =db.getFlightByRC(code);
            }
            else {
                String result="";
                String pageRaw= request.getParameter("page");
                if(pageRaw==null) pageRaw="1";
                int pageGap = DataConfig.getPageGap();
                int totalBooking= db.getTotalBooking();
                int pageSize = DataConfig.getPageSize();
                int totalPage = totalBooking / pageSize + (totalBooking % pageSize == 0 ? 0 : 1);
                try {
                    int pageIndex = Integer.parseInt(pageRaw);
                    list =db.getAllFlights(pageIndex, pageSize);
                    if(pageIndex <=totalPage) {
                         result=Pagger.generate(pageIndex,pageSize,totalBooking,"?page=",pageGap);
                    }
                    else result="No Results";
                } catch (Exception e) {
                     result="No Results";
                }
                request.setAttribute("pagger", result);
           }
            FlightDAO db2= new FlightDAO();
            LoginDAO db3= new LoginDAO();
         
            request.setAttribute("active", "manage");
            HashMap<String ,ArrayList<Object>> map = new HashMap<>();
            for(Booking s :list){
                ArrayList<Object> ds = new ArrayList<>();
                ds.add(db3.getUserByID(s.getUserID()));
                ds.add(db2.getFlightByID(s.getFlight1ID()));
                ds.add(db2.getFlightByID(s.getFlight2ID()));
                ds.add(s.getTimeBook());
                map.put(s.getReservationCode(), ds);
            }
            request.setAttribute("map", map);
           
            request.getRequestDispatcher("view/resultBooking.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ManageBookController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ManageBookController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
