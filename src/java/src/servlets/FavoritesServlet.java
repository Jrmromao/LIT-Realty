/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import src.db.PropertiesDB;
import src.entities.Properties;

/**
 *
 * @author jrmromao
 */
@WebServlet(name = "FavoritesServlet", urlPatterns = {"/Favorites"})
public class FavoritesServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String id = request.getParameter("id");
            String ids = null;
            boolean flag = false;
            String cookieValue = "";
            String cookieName = "propertyId";
            Cookie propertyIds = null;
            Cookie[] cookies = request.getCookies();

            if (id == null) {

            } else {
                for (Cookie c : cookies) {
                    if (cookieName.equals(c.getName())) {
                        cookieValue = c.getValue();
                    }
                }
                String[] cookieString = cookieValue.split(" ");


                for (String val : cookieString) {
                    if (val.equals(id)) {
                        flag = true;
                    } else {
                        flag = false;
                    }
                }
                if (flag) {

                } else {

                    for (Cookie cookie : cookies) {

                        if (cookie.getName().equals(cookieName)) {
                            ids = cookie.getValue();
                            cookie.setValue(ids + " " + id);
                            cookie.setMaxAge(60 * 60 * 365 * 1);
                            response.addCookie(cookie);

                        } else if (!cookie.getName().equals("propertyId")) {
                            propertyIds = new Cookie("propertyId", request.getParameter("id"));
                            propertyIds.setMaxAge(60 * 60 * 365 * 2);
                            response.addCookie(propertyIds);
                        }
                    }
                }
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("MyFavorites");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
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
    } // </editor-fold>

}
