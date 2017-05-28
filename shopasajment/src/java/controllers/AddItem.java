/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import model.Item;
import model.ItemDAO;

/**
 *
 * @author bm
 */
@MultipartConfig
public class AddItem extends HttpServlet {

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

        String action = request.getParameter("categoryselect");

        if (action.equals("empty")) {
            response.sendRedirect("?m=admin");
        }

        if (action.equals("Insert")) {
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            Double price = Double.parseDouble(request.getParameter("price"));
            int categoryId = Integer.parseInt(request.getParameter("categoryid"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            Part imagePart = request.getPart("image");
            String imageName = imagePart.getSubmittedFileName();

            InputStream is = imagePart.getInputStream();
            try (FileOutputStream fos = new FileOutputStream("c:/Users/bm/Desktop/NB projects/shopasajment/web/images/" + imageName)) {
                int b;
                while ((b = is.read()) != -1) {
                    fos.write(b);
                }
            }

            Item item = new Item(name, description, price, "images/" + imageName, categoryId, quantity);

            ItemDAO dao = new ItemDAO();
            dao.insert(item);

            sesija.setAttribute("itemError", "Item successfully added");
            response.sendRedirect("?m=admin");
        }

        if (action.equals("Remove")) {
            ItemDAO dao = new ItemDAO();
            Item item = (Item) sesija.getAttribute("searchedItem");
            dao.delete(item.getId());
            sesija.removeAttribute("searchedItem");
            response.sendRedirect("?m=admin");
        }

        if (action.equals("Edit")) {
            ItemDAO dao = new ItemDAO();
            Item item = (Item) sesija.getAttribute("searchedItem");
            try {
                item.setName(request.getParameter("name"));
                item.setDescription(request.getParameter("description"));
                item.setPrice(Double.parseDouble(request.getParameter("price")));
                item.setCategory(Integer.parseInt(request.getParameter("categoryid")));
                item.setQuantity(Integer.parseInt(request.getParameter("quantity")));
            } catch (NumberFormatException ex) {
                sesija.setAttribute("itemError", "Please add data to all fields");
            }

            Part imagePart = request.getPart("image");
            String imageName = imagePart.getSubmittedFileName();
            InputStream is = imagePart.getInputStream();
            try (FileOutputStream fos = new FileOutputStream("c:/Users/bm/Desktop/NB projects/shopasajment/web/images/" + imageName)) {
                int b;
                while ((b = is.read()) != -1) {
                    fos.write(b);
                }
            }
            item.setImage("images/" + imageName);

            dao.updateItem(item.getId(), item);
            sesija.setAttribute("itemError", "Item successfully updated");
            sesija.removeAttribute("searchedItem");
            response.sendRedirect("?m=admin");
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
