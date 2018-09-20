/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import org.eclipse.persistence.jpa.jpql.parser.ElseExpressionBNF;
import src.db.PropertiesDB;
import src.db.PropertyviewsDB;
import src.db.VendorDB;
import src.entities.Properties;
import src.entities.Propertyviews;
import src.entities.Vendor;

/**
 *
 * @author jrmromao
 */
@WebServlet(name = "PropDetailServlet", urlPatterns = {"/PropDetailServlet"})
public class PropDetailServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String address;

        int propId = Integer.parseInt(request.getParameter("id"));

        int totalView = 0;
        try {

            Properties p = PropertiesDB.getPropDetails(propId);
            List<Propertyviews> cView = PropertyviewsDB.getViewByPropID(propId);
            if (p == null) {
                address = "error.jsp";
            } else {

                for (Propertyviews pv : cView) {
                    totalView = totalView + pv.getNumViews();
                }

                manageView(propId);
                address = "propDetails.jsp";

                String path = getServletContext().getRealPath("/resources/images/properties/large/" + p.getListingNum() + "/");

                ArrayList<String> photoList = getFile(path);
                Vendor vendor = VendorDB.getVendorById(p.getVendorId());

                request.setAttribute("vendor", vendor);
                request.setAttribute("prop", p);
                request.setAttribute("iList", photoList);
                request.setAttribute("totalView", totalView);
                request.setAttribute("page", "Property Detail");

            }
        } catch (Exception e) {

            address = "error.jsp";
            System.err.println("ERROR - Property details servlet");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);

    }

    private ArrayList<String> getFile(String dirPath) {

        ArrayList<String> fileList = new ArrayList<String>();

        File f = new File(dirPath);

        for (File file : f.listFiles()) {

            if (file.isFile()) {
                fileList.add(file.getName());
            }
        }
        return fileList;
    }

    private void manageView(int propId) {

     

        List<Propertyviews> vList = null;

         
 
        
        try {
            
            String ipAddress = InetAddress.getLocalHost().getHostAddress();
            vList = PropertyviewsDB.getAllView();

          Propertyviews  pv = PropertyviewsDB.hasView(propId, ipAddress);

          

            if (pv==null) {

                Propertyviews pview = new Propertyviews();

                pview.setNumViews(1);
                pview.setPropID(propId);
                pview.setUserIP(ipAddress);
                
                
                PropertyviewsDB.addPropView(pview);
            }

        } catch (Exception e) {

        } finally {
            vList.clear();
           
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
    }// </editor-fold>

}
