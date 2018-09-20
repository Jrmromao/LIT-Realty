/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import src.db.UserDB;
import src.db.PropertiesDB;
import src.db.PropertyTypesDB;
import src.entities.User;
import src.entities.Properties;
import src.entities.Propertytypes;
import sun.management.Agent;

/**
 *
 * @author jrmromao
 */
@WebServlet(name = "SignUpServlet", urlPatterns = {"/SignUpServlet"})
public class SignUpServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        User  u = new User();
        String address = null;
        boolean flag = false;
        
        PrintWriter out = response.getWriter();
        out.print(request.getParameter("photo"));
      String appPath = request.getServletContext().getRealPath("");
      out.print(appPath);
        try {

            String name = request.getParameter("name");
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String confirm_password = request.getParameter("confirm_password");
            int role = Integer.parseInt(request.getParameter("category"));
            String contactNum = request.getParameter("phone");
            String faxNo = request.getParameter("fax");

            
            if (password.equals(confirm_password)) {

                String passHash = org.apache.commons.codec.digest.DigestUtils.sha256Hex(password); 
                
                u.setName(name);
                u.setUsername(username);
                u.setPhone(contactNum);
                u.setFax(faxNo);
                u.setEmail(email);
                u.setPassword(passHash);
                u.setRole(role);

                if (!UserDB.registerUser(u)) {
                    address = "error.jsp";
                } else {
                    address = "login.jsp";
                    request.setAttribute("page", "Login");
                }

            } else {
                address = "LoadRegister";
                request.setAttribute("msg", "Passwords do not match!");
            }


        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.toString());
            address = "error.jsp";
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);

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
