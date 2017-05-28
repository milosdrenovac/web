/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Item;
import model.ItemDAO;
import model.Purchase;
import model.PurchaseDAO;
import model.PurchaseItem;
import model.PurchaseItemDAO;
import model.UserDAO;

/**
 *
 * @author bm
 */
public class Finalized extends HttpServlet {

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

        HttpSession sesija = request.getSession();
        Object currFunds = sesija.getAttribute("vallet");
        Double wallet = Double.parseDouble(currFunds.toString());
        Object price = sesija.getAttribute("allprice");
        Double paid = Double.parseDouble(price.toString());

        Double remaining = wallet - paid;
        sesija.setAttribute("vallet", remaining);
        int id = Integer.parseInt(sesija.getAttribute("id").toString());
        UserDAO.updateFunds(remaining, id);

        Purchase p = new Purchase(id, paid, new java.util.Date());
        PurchaseDAO dao = new PurchaseDAO();
        ItemDAO daoi = new ItemDAO();
        dao.insert(p);
        PurchaseItemDAO daop = new PurchaseItemDAO();

        ArrayList cart = (ArrayList) sesija.getAttribute("cart");
        for (Object iteration : cart) {
            Item item = new Item();
            item = (Item) iteration;
            System.out.println(item.getQuantity()-1);
            item.setQuantity(item.getQuantity()-1);
            daoi.updateItem(item.getId(), item);
            PurchaseItem pi = new PurchaseItem(p.getId(), item.getId());
            daop.insert(pi);
        }
        cart.clear();
        
        sesija.setAttribute("cart", cart);
        sesija.removeAttribute("allprice");
        response.sendRedirect("?m=finalized");
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
