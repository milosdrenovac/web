/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ItemDAO;
import model.Purchase;
import model.PurchaseDAO;
import model.PurchaseItemDAO;
import model.User;
import model.UserDAO;

/**
 *
 * @author bm
 */
public class ManipulateUser extends HttpServlet {

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
        HttpSession sesija = request.getSession();
        int id = Integer.parseInt(request.getParameter("userid"));
        UserDAO dao = new UserDAO();

        if (request.getParameter("action").equals("Delete")) {
            dao.delete(id);
            sesija.removeAttribute("searchList");
            response.sendRedirect("?m=userremoved");
        }
        if (request.getParameter("action").equals("Edit")) {
            try {
                User user = dao.selectById(id);
                sesija.setAttribute("usertoedit", user);
                sesija.removeAttribute("searchList");
                response.sendRedirect("?m=edituser");
            } catch (SQLException ex) {
                Logger.getLogger(ManipulateUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (request.getParameter("action").equals("View Purchases")) {
            try {
                ItemDAO daoi = new ItemDAO();
                ArrayList<Purchase> listp = (ArrayList) PurchaseDAO.select(id);

                for (Purchase purchase : listp) {
                    int idp = purchase.getId();
                    ArrayList listpi = (ArrayList) daoi.selectFromPurchases(idp);
                    purchase.setAllitems(listpi);
                }

                User user = dao.selectById(id);
                sesija.setAttribute("userpurchases", user);
                sesija.setAttribute("purchases", listp);
                response.sendRedirect("?m=purchases");
            } catch (SQLException ex) {
                Logger.getLogger(ManipulateUser.class.getName()).log(Level.SEVERE, null, ex);
            }

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
