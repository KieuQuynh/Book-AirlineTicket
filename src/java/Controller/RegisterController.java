/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DB.LoginDAO;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
public class RegisterController extends HttpServlet {

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
    
    public boolean validateEmail(String s){
        String regex = "(.+)@(.+)(\\..+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        return s.matches(regex);
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
        request.getRequestDispatcher("view/register.jsp").forward(request, response);
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
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String verifypassword = request.getParameter("verifypassword");
            String fristName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String cardNumber = request.getParameter("cardNumber");
            String phoneNumber = request.getParameter("phoneNumber");
            String address = request.getParameter("address");
            String age = request.getParameter("age");
            String sex = request.getParameter("sex");
            LoginDAO db = new LoginDAO();
            boolean f = db.checkEmailExist(email);
            boolean f2 = false;
            boolean f3=false;
            System.out.println(validateEmail(email));
            if (f) {
                request.setAttribute("errorEmail", "This Email has been registed");
                System.out.println("f");
            }

            if (password.equals("") || verifypassword.equals("") || fristName.equals("")
                    || lastName.equals("") || cardNumber.equals("") || phoneNumber.equals("")
                    || address.equals("") || age.equals("")) {
                f2 = true;
                request.setAttribute("errorData", "*required");
                System.out.println("f2");
            }
            
            if((!password.equals("") && !verifypassword.equals("")) && (!password.equals(verifypassword))) {
                request.setAttribute("errorPass", "VerifyPass not same password");
                f3=true;
                System.out.println("f3");
            }
            
            if(!f && !f2 && !f3){
                User  ob = new User();
                ob.setEmail(email);
                ob.setPassword(password);
                ob.setFirstName(fristName);
                ob.setLastName(lastName);
                ob.setPhone(phoneNumber);
                ob.setAddress(address);
                ob.setAge(Integer.parseInt(age));
                ob.setCardNumber(cardNumber);
                boolean x =false;
                if(sex.equals("1")) x=true;
                ob.setSex(x);
                db.insertUser(ob);
                response.sendRedirect("login");
            }
            
            else {
                request.getRequestDispatcher("view/register.jsp").forward(request, response);
            }
            

        } catch (Exception ex) {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
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
