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
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import src.db.PropertiesDB;
import src.db.StatusDB;
import src.db.UserDB;
import src.entities.Properties;
import src.entities.Status;
import src.entities.User;

/**
 *
 * @author jrmromao
 */
@WebServlet(name = "AgentLoginServlet", urlPatterns = {"/AgentLoginServlet"})
public class AgentLoginServlet extends HttpServlet {

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

        String address = null;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rememberMe = request.getParameter("rememberMe");
        UsernamePasswordToken toke = new UsernamePasswordToken(username, password);
        toke.setRememberMe(true);
        org.apache.shiro.subject.Subject currentUser = SecurityUtils.getSubject();

        try {

            currentUser.login(toke);
            if (currentUser.isAuthenticated()) {
                HttpSession session = request.getSession();

                session.setAttribute("username", username);

                address = "adminPage.jsp";
                User u = UserDB.getUserObj(username);

                session.setAttribute("id", u.getUserId());

                HttpSession sess = request.getSession();
                List<Properties> pList = PropertiesDB.getPropertyByAgent(u.getUserId());
 
                
                    List<Properties> soldProp = new ArrayList<Properties>();
                
                
                
                for (Properties pr : pList) {
                    
                    
                    if (pr.getStatusId() == 2) {
                        soldProp.add(pr);
                    }
                }
                
                
                sess.setAttribute("soldPro", soldProp);
                
                
                
                
                sess.setAttribute("list", pList);
                sess.setAttribute("agent", u);
                sess.setAttribute("role", u.getRole());
                sess.setAttribute("page", username);

            } else {
                address = "agentLogin.jsp";
                request.setAttribute("message", "Username or Password do not match!");
            }

        } catch (Exception e) {
           
            String alert = "Wrong Username or password";
            request.setAttribute("message", alert);

            address = "agentLogin.jsp";

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
