/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.servlets.agent;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import javax.websocket.Session;
import src.db.PropertiesDB;
import src.db.VendorDB;
import src.entities.Properties;
import src.entities.Vendor;

/**
 *
 * @author jrmromao
 */
@WebServlet(name = "AgentProperties", urlPatterns = {"/AgentProperties"})
public class AgentPropertiesServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String address = null;
        try {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();

            String id = (String) session.getAttribute("id").toString();

             List<Vendor> vList = new ArrayList<Vendor>();
            
             
            List<Properties> pList = PropertiesDB.getPropertyByAgent(Integer.parseInt(id));
 
            for (Properties p : pList) {
                
                
               vList.add(VendorDB.getVendorById(p.getVendorId()));
                
            }
            
   
            
            
            
            request.setAttribute("page", "Agent Properties");
            request.setAttribute("vList", vList);
            request.setAttribute("pList", pList);
            address = "agentProperties.jsp";

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.toString());
            String alert = "<script>alert(\"some fields are empty!\");</script>";
            request.setAttribute("alert", alert);

            address = "agentProperties";

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
        protected void doGet
        (HttpServletRequest request, HttpServletResponse response)
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
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>

    }
