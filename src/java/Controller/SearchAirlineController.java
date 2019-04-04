/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DB.CityDAO;
import DB.FlightDAO;
import Model.Flight;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
public class SearchAirlineController extends HttpServlet {

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

            String typeTrip = request.getParameter("typeTrip");
            String fromRaw = request.getParameter("from");
            String toRaw = request.getParameter("to");
            String dateRaw = request.getParameter("departure");
            String returns = request.getParameter("returns");
            request.setAttribute("active", "book");
            boolean f1 = false;
            boolean f2 =false;
            boolean f3=false;
            boolean f4=false;
      //get current date   
    java.util.Date today = new java.util.Date();        //date1
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");   
    String currentDate =sdf.format(today);
    java.util.Date f = sdf.parse(currentDate);
            
         
            if (dateRaw.equals("") ) {
                request.setAttribute("errorData", "*required");
                f1=true;
            }
            
            if(typeTrip.equals("roundTrip") && returns.equals("")){
                request.setAttribute("errorData", "*required");
                f1=true;
            }
            
          if(!f1){
              java.util.Date date1 = sdf.parse(dateRaw);
              if(f.compareTo(date1) >0 )  {
                  f3=true;
              }
              java.util.Date date2=null;
              if(returns!=null &&!returns.equals("")) {
                  date2= sdf.parse(returns);
                  if(f.compareTo(date2) >0 )  
                  f3=true;
                  if(date1.compareTo(date2) > 0){
                      f4=true;
                      request.setAttribute("errorReturnDate", "returnDate equal or more than departDate");
                  }
              }
              
              
          }  
           if(f3) request.setAttribute("errorDate", "please select date from current date");
           
            
            int from = Integer.parseInt(request.getParameter("from"));
            int to = Integer.parseInt(request.getParameter("to"));

            if (from == to) {
                request.setAttribute("myError", "From must be different To");
                f2=true;
            }
           
            Date date = null;
            if ( (!f1 && !f2 && !f3 && !f4 ) ) {
              
                date = Date.valueOf(request.getParameter("departure"));
                CityDAO cityDAO = new CityDAO();
                request.setAttribute("from", cityDAO.getCity(from));
                request.setAttribute("to", cityDAO.getCity(to));

                FlightDAO db = new FlightDAO();

                //when user selected onetrip
                if (typeTrip.equals("oneTrip")) {
                    System.out.println("onetrip");
                    ArrayList<Flight> list = db.getFlight(from, to, date);
                    System.out.println("size mmm :" + list.size());
                    if (list.size() == 0) {
                        request.setAttribute("resultSearch", "No Flights Avaliable");
                    } else {
                        request.setAttribute("resultSearch", "");
                        request.setAttribute("list", list);

                    }

                } else {
                    Date returnDate = Date.valueOf(request.getParameter("returns"));
                    ArrayList<Flight> list = db.getFlight(from, to, date);
                    ArrayList<Flight> list2 = db.getFlight(to, from, returnDate);
                    if (list.size() == 0 || list2.size() == 0) {
                        request.setAttribute("resultSearch", "No Flights Avaliable");
                    } else {
                        request.setAttribute("list", list);
                        request.setAttribute("list2", list2);
                        request.setAttribute("resultSearch", "");
                    }
                }
                 System.out.println("no nhay vao day");
                request.getRequestDispatcher("view/book.jsp").forward(request, response);

            } else {
                
                request.getRequestDispatcher("home").forward(request, response);

            }

        } catch (Exception ex) {
             Logger.getLogger(BookingController.class.getName()).log(Level.SEVERE, null, ex);
        }

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
