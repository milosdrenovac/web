package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;
import model.UserDAO;

public class Login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
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
        try {
            processRequest(request, response);
            
            String username = request.getParameter("username").trim();
            String password = request.getParameter("password").trim();
            
            User user = new User();
            UserDAO dao = new UserDAO();
            
            user=dao.select(username, password);

            HttpSession sess = request.getSession();
            sess.setAttribute("id", user.getId());
            sess.setAttribute("username", user.getUsername());
            sess.setAttribute("last_name", user.getLastName());
            sess.setAttribute("first_name", user.getFirstName());
            sess.setAttribute("password", user.getPassword());
            sess.setAttribute("purchases", user.getPurchases());
            sess.setAttribute("vallet", user.getVallet());
            sess.setAttribute("role", user.getRole());
            
            if(sess.getAttribute("username")!=null)
                response.sendRedirect("?m=loginsuccess");
            else
                response.sendRedirect("?m=login");
            
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
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
