/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import src.db.PropertiesDB;
import src.entities.Properties;

/**
 *
 * @author jrmromao
 */
@WebServlet(name = "UpdatePropertyDervlet", urlPatterns = {"/UpdatePropertyDervlet"})
public class UpdatePropertyDervlet extends HttpServlet {

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
        
        
        try {

            Properties p = new Properties();

            int propId = Integer.parseInt(request.getParameter("propId"));
            int vendorID = Integer.parseInt(request.getParameter("vendorID"));

            String street = request.getParameter("street");
            String city = request.getParameter("city");
            


            String bedrooms = request.getParameter("bedrooms");
            String bathrooms = request.getParameter("bathrooms");
            String squarefeet = request.getParameter("squarefeet");
            String berRating = request.getParameter("berRating");
            String lotSize = request.getParameter("lotSize");
            String price = request.getParameter("price");
            String garageID = request.getParameter("garageId");
            String typeId = request.getParameter("typeId");
            String styleId = request.getParameter("styleId");
            String description = request.getParameter("description");

            HttpSession session = request.getSession();
            String id = session.getAttribute("id").toString();
            Date d = new Date();

            p.setAgentId(Integer.parseInt(id));
            p.setStreet(street);
            p.setCity(city);

            
            p.setId(propId);
            p.setVendorId(vendorID);

            p.setBedrooms(Integer.parseInt(bedrooms));
            p.setBathrooms(Float.parseFloat(bathrooms));
            p.setSquarefeet(Integer.parseInt(squarefeet));
            p.setBerRating(berRating);
            p.setLotsize(lotSize);
            p.setPrice(Double.parseDouble(price));
            p.setDateAdded(d);
            p.setGarageId(Integer.parseInt(garageID));
            p.setTypeId(Integer.parseInt(typeId));
            p.setStyleId(Integer.parseInt(styleId));
            p.setDescription(description);

            
            if(PropertiesDB.updateProperty(p)){
                address = "AgentProfile";
                  alert = "<script>alert(\"Property Updated!\");</script>";
                
            }else{
                  alert = "<script>alert(\"ERROR when updating the property the propry!\");</script>";
            }

            
              request.setAttribute("alert", alert);
           
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "UPDATE PROPERTY: "+e.getMessage());
          
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
