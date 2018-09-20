/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.servlets.ManageVendor;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import src.db.PropertiesDB;
import src.db.VendorDB;
import src.entities.Vendor;

/**
 *
 * @author jrmromao
 */
@WebServlet(name = "AddVendorServlet", urlPatterns = {"/AddVendorServlet"})
public class AddVendorServlet extends HttpServlet {

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
     
        
        String address = null, alert = null;
        
        
        

        String name = request.getParameter("name");
        String vebdirAddress = request.getParameter("address");
        String phonNum = request.getParameter("num");

        try {

            Vendor v = new Vendor();

    
            v.setName(name);
            v.setAddress(vebdirAddress);
            v.setPhoneNum(phonNum);

            if (!VendorDB.addVendor(v)) {
                address = "ManageVendorsServlet";
               alert = "<script>alert(\"ERROR when adding vendor!\");</script>";
            } else {
                address = "ManageVendorsServlet";
                alert = "<script>alert(\"Vendor Added!\");</script>";
                
                request.setAttribute("page", "Manage Vendor");
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
