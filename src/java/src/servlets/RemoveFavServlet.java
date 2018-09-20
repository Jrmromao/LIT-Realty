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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jrmromao
 */
@WebServlet(name = "RemoveFavServlet", urlPatterns = {"/RemoveFavServlet"})
public class RemoveFavServlet extends HttpServlet {


    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String newString = "";
        String address = "";

        try {
            String PropId = request.getParameter("id");
            for (Cookie cookie : request.getCookies()) {
                String idString = cookie.getValue();
                String[] items = idString.split(" ");
                
                request.setAttribute("cookieList", items);
                
                if (cookie.getName().equals("propertyId")) {

                    for (String Id : items) {
                        if (Id.equals(PropId)) {
                            Id = Id.replace(Id, " ");
                        } else {
                            newString += Id + " ";
                        }
                    }
                }
                if (cookie.getName().equals("propertyId")) {

                    cookie.setValue(newString);
                    cookie.setMaxAge(60 * 60 * 365 * 2);
                    response.addCookie(cookie);
                }
            }

        }//end try
        catch (Exception ex) {
            address = "/Error.jsp";
        }//end catch
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
