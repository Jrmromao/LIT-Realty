/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import src.db.PropertiesDB;
import src.db.UserDB;
import src.entities.Properties;
import src.entities.User;

/**
 *
 * @author jrmromao
 */
@WebServlet(name = "LoadFavorites", urlPatterns = {"/MyFavorites"})
public class LoadFavorites extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String address = null;

        try {
            String cookieName = "propertyId";
            String cookieValue = "";
            Cookie[] cookies = request.getCookies();

            for (int i = 0; i < cookies.length; i++) {
                Cookie c = cookies[i];

                if (cookieName.equals(c.getName())) {
                    cookieValue = c.getValue();
                }
            }
            String[] cookieString = cookieValue.split(" ");

            List<Properties> pList = new ArrayList<Properties>();
            List<String> listA = new ArrayList();

            
            
            for (String s : cookieString) {

                if (s.equals("")) {

                } else {
                   
                    listA.add(s);
                    Properties p = new Properties();
                    p = PropertiesDB.getPropDetails(Integer.parseInt(s));                  
                    pList.add(p);
                }

            }

            request.setAttribute("flist", listA);
            request.setAttribute("pList", pList);
            request.setAttribute("cookieArr", cookieString);
            address = "favorites.jsp";

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "LOAD FAVORITES SERVLET" + e.toString());
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
