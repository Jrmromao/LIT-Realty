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
import src.db.PropertyTypesDB;
import src.db.UserDB;
import src.entities.Properties;
import src.entities.Propertytypes;
import src.entities.User;

/**
 *
 * @author jrmromao
 */
@WebServlet(name = "LoadAdvanceSerachServlet", urlPatterns = {"/AdvanceSerach"})
public class AdvanceSerachServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String address = null;
        String noProp = null;
        try {
          
            
            String location = request.getParameter("location");
            double priceParam = Double.parseDouble(request.getParameter("price"));
            int propType = Integer.parseInt(request.getParameter("type"));
            int bedrrrom = Integer.parseInt(request.getParameter("nBedrooms"));
            int squareFeet = Integer.parseInt(request.getParameter("squarefeet"));
            
            
            List<Properties> sList = PropertiesDB.advancedSearchResult(priceParam, location, propType, bedrrrom, squareFeet);
            List<Propertytypes> tList = PropertyTypesDB.getPropTypet();
            
            if (sList.isEmpty()) {
                noProp = "<script>alert(\"No properties  in the given location!\");</script>";
                request.setAttribute("alert", noProp);
                address = "/Index";

            } else {

                address = "searchResult.jsp";
                request.setAttribute("tList", tList);
                request.setAttribute("list", sList);
            }
            
            
        } catch (Exception e) {

            JOptionPane.showConfirmDialog(null, e.toString());
            
            //noProp = "<script>alert(\"some fields are empty!"+e.toString()+"\");</script>";
            //request.setAttribute("alert", noProp);
            address = "Index";
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
