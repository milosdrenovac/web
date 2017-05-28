package sitectrl;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import model.Category;
import model.CategoryDAO;
import sys.BaseController;

public class UserController extends BaseController {

    public void home() {
        view("start");
        if (request.getSession() != null) {
            HttpSession sesija = request.getSession();
            sesija.removeAttribute("searchList");
            sesija.removeAttribute("searchedItem");
            sesija.removeAttribute("errormsg");
            sesija.removeAttribute("itemError");
        }
    }

    public void login() {
        view("login.jsp");
        if (request.getSession() != null) {
            HttpSession sesija = request.getSession();
            sesija.removeAttribute("searchList");
            sesija.removeAttribute("searchedItem");
            sesija.removeAttribute("errormsg");
            sesija.removeAttribute("itemError");
        }
    }

    public void register() {
        view("register.jsp");
        if (request.getSession() != null) {
            HttpSession sesija = request.getSession();
            sesija.removeAttribute("searchList");
            sesija.removeAttribute("searchedItem");
            sesija.removeAttribute("itemError");
        }
    }

    public void loginsuccess() {
        view("loginsuccess.jsp");
    }

    public void registersuccess() {
        view("registersuccess.jsp");
    }

    public void loggedout() {
        view("loggedout.jsp");
    }

    public void itemdetails() {
        view("Itemdetails");
    }

    public void addtocart() {
        view("Addtocart");
    }

    public void cart() {
        view("cart.jsp");
        if (request.getSession() != null) {
            HttpSession sesija = request.getSession();
            sesija.removeAttribute("searchList");
            sesija.removeAttribute("searchedItem");
            sesija.removeAttribute("errormsg");
            sesija.removeAttribute("itemError");
        }
    }

    public void billing() {
        view("billing.jsp");
    }

    public void finalized() {
        view("finalized.jsp");
    }

    public void admin() {
        List<Category> listAllCat = new ArrayList<Category>();
        listAllCat = CategoryDAO.getAll();
        request.setAttribute("allCategories", listAllCat);
        view("adminpanel.jsp");
    }

    public void userremoved() {
        view("userremoved.jsp");
    }

    public void edituser() {
        view("edituser.jsp");
    }

    public void userupdated() {
        view("userupdated.jsp");
    }

    public void purchases() {
        view("purchases.jsp");
    }

}
