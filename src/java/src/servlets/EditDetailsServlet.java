/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import src.db.UserDB;
import src.entities.User;

/**
 *
 * @author jrmromao
 */
@WebServlet(name = "EditDetailsServlet", urlPatterns = {"/EditDetailsServlet"})
public class EditDetailsServlet extends HttpServlet {

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
         String address, alert;
         


        try {

            User u = new User();

            u.setUserId(Integer.parseInt(request.getParameter("agentID")));
            u.setUsername(request.getParameter("username"));
            u.setPassword(request.getParameter("password"));
            u.setName(request.getParameter("name"));
            u.setPhone(request.getParameter("phone"));
            u.setFax(request.getParameter("fax"));
            u.setEmail(request.getParameter("email"));

            if (UserDB.updateUserDetails(u)) {

                alert = "<script>alert(\"Details Updated!\");</script>";
                address = "AgentProfile";
            } else {
                alert = "<script>alert(\"Something went Wrong\");</script>";
                address = "editProfileDetails.jsp";
            }

            request.setAttribute("alert", alert);
            request.setAttribute("page", "Edit Details");

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
