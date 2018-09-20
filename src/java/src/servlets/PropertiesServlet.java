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
import src.db.PropertiesDB;
import src.entities.Properties;
import java.net.InetAddress;
import src.db.PropertyviewsDB;
import src.entities.Propertyviews;

/**
 *
 * @author jrmromao
 */
@WebServlet(name = "PropertiesServlet", urlPatterns = {"/Properties"})
public class PropertiesServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        
        String address;
        int agentID = Integer.parseInt(request.getParameter("agentID"));

         try {

       List<Properties> sList = PropertiesDB.getPropertyByAgent(agentID);
            
            if (sList.isEmpty()) {
                JOptionPane.showConfirmDialog(null, sList.size());
                address = "error.jsp";
            } else { 
                       
                 address = "searchResult.jsp";
                request.setAttribute("list", sList);
            }
        } catch (Exception e) {
            //JOptionPane.showConfirmDialog(null, e.toString());
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
