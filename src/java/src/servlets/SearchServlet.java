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
import src.entities.Propertytypes;
import src.db.PropertyTypesDB;
/**
 *
 * @author jrmromao
 */
@WebServlet(name = "SearchServlet", urlPatterns = {"/SearchServlet"})
public class SearchServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String address = null;
        String noProp = null;
        try {
            String location = request.getParameter("location");
            int priceParam = Integer.parseInt(request.getParameter("price"));
            int propType = Integer.parseInt(request.getParameter("type"));
            double maxPrice = 0.0;
            double minPrice = 0.0;

            switch (priceParam) {
                case 1:
                    minPrice = 0;
                    maxPrice = 100000;
                    break;
                case 2:
                    minPrice = 100000;
                    maxPrice = 200000;
                    break;
                case 3:
                    minPrice = 200000;
                    maxPrice = 300000;
                    break;
                case 4:
                    minPrice = 300000;
                    maxPrice = 400000;
                    break;
                case 5:
                    minPrice = 400000;
                    maxPrice = 500000;
                    break;
                case 6:
                    minPrice = 500000;
                    maxPrice = 600000;
                    break;
                case 7:
                    minPrice = 600000;
                    maxPrice = 700000;
                    break;
                case 8:
                    minPrice = 700000;
                    maxPrice = 800000;
                    break;
                case 9:
                    minPrice = 800000;
                    maxPrice = 900000;
                    break;
                case 10:
                    minPrice = 900000;
                    maxPrice = 1000000;
                    break;
                default:
                    System.err.println("Price error");

            }

            List<Properties> sList = PropertiesDB.searchResult(minPrice, maxPrice, location, propType);
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

            noProp = "<script>alert(\"some fields are empty!\");</script>";
            request.setAttribute("alert", noProp);
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
