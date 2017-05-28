/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;
import model.UserDAO;

public class Register extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
        HttpSession sesija = request.getSession();
        
        try {
            
            String user = request.getParameter("username").trim();
            String password = request.getParameter("password").trim();
            String first_name = request.getParameter("first_name").trim();
            String last_name = request.getParameter("last_name").trim();
            double wallet = Double.parseDouble(request.getParameter("wallet").trim());
            boolean admin = request.getParameter("admincheck")!=null;
            System.out.println(admin);

            User u = new User();
            u.setUsername(user);
            u.setPassword(password);
            u.setFirstName(first_name);
            u.setLastName(last_name);
            u.setVallet(wallet);
            if (admin) {
                u.setRole(2);
            } else {
                u.setRole(1);
            }

            UserDAO.insert(u);

            HttpSession sess = request.getSession();
            sess.setAttribute("id", u.getId());
            sess.setAttribute("username", u.getUsername());
            sess.setAttribute("last_name", u.getLastName());
            sess.setAttribute("first_name", u.getFirstName());
            sess.setAttribute("password", u.getPassword());
            sess.setAttribute("purchases", u.getPurchases());
            sess.setAttribute("vallet", u.getVallet());
            sess.setAttribute("role", u.getRole());
            if (u.getRole() == 1) {
                sess.setAttribute("role", "admin");
            } else {
                sess.setAttribute("role", "user");
            }
            response.sendRedirect("?m=registersuccess");
        } catch (NumberFormatException ex) {
            PrintWriter out = response.getWriter();
            sesija.setAttribute("errormsg", "Invalid input type please try again..");
            response.sendRedirect("?m=register");
            
            
        }
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
