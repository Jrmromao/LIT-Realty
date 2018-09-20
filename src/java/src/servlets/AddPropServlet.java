/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import org.apache.jasper.tagplugins.jstl.core.Out;
import src.db.UserDB;
import src.db.PropertiesDB;
 
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import src.entities.Properties;

/**
 *
 * @author jrmromao
 */
@WebServlet(name = "AddPropServelt", urlPatterns = {"/AddPropServelt"})
public class AddPropServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

       
Properties p = new Properties();
        String address = null;
        boolean flag = false;
//        
//        ServletFileUpload st = new ServletFileUpload(new DiskFileItemFactory());
//        List<FileItem> multiFile;
//        
//       
//        String img = request.getParameter("img");
//        
        
        
        String street = request.getParameter("street");
        String city = request.getParameter("city");
        String listingNum = request.getParameter("listingNum");
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

        
        
        Date d = new Date();

        p.setAgentId(1); 
        p.setStreet(street);
        p.setCity(city);
        p.setListingNum(Integer.parseInt(listingNum));
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

    
        
        try {

            if (!PropertiesDB.addProperty(p)) {
                address = "error.jsp";
            } else {
                address = "manageProperty.jsp";
                request.setAttribute("page", "Login");
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.toString());
            address = "error.jsp";
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
 
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

  
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    
  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
