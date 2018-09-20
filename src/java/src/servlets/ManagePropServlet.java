/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.servlets;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;
import javax.swing.JOptionPane;
import org.apache.catalina.authenticator.Constants;
import src.db.PropertiesDB;
import src.db.StatusDB;
import src.db.VendorDB;
import src.entities.User;
import src.entities.Properties;
import src.entities.Propertytypes;
import src.entities.Status;
import src.entities.Vendor;

/**
 *
 * @author jrmromao
 */
@WebServlet(name = "ManagePropServlet", urlPatterns = {"/ManagePropServlet"})
public class ManagePropServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String address = null;

        try {
            HttpSession session = request.getSession();
            User a = (User) session.getAttribute("agent");

            List<Properties> propList = PropertiesDB.getPropertyByAgent(a.getUserId());
            List<Vendor> vList = VendorDB.getAllVendors();
            List<Properties> newList = new ArrayList<Properties>();
  

        

            if (propList.isEmpty() || vList.isEmpty()) {
                address = "error";

            } else {

                address = "manageProperty.jsp";
                request.setAttribute("allProp", propList);
                session.setAttribute("sList", newList);

                request.setAttribute("vList", vList);
                request.setAttribute("page", "Manage Property");
            }
        } catch (Exception e) {
            //JOptionPane.showConfirmDialog(null, e.toString());
            //address = "error.jsp";
              address = "manageProperty.jsp";
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
