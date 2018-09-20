/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.security.auth.Subject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import src.db.UserDB;
import src.entities.User;

/**
 *
 * @author jrmromao
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String address = null;
        String username = request.getParameter("username");
        String password = request.getParameter("password");


        UsernamePasswordToken toke = new UsernamePasswordToken(username, password);
        toke.setRememberMe(true);
        org.apache.shiro.subject.Subject currentUser = SecurityUtils.getSubject();

        try {
            currentUser.login(toke);
            
            if (currentUser.isAuthenticated()) {

               User u = UserDB.getUserObj(username);
               HttpSession sess = request.getSession();
               sess.setAttribute("agent", u);
               request.setAttribute("page",  username);
                address = "profile.jsp";
            } else {
                address = "login.jsp";
                request.setAttribute("message", "Username or Password do not match!");
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,"Sheiro"+ e.toString());
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
