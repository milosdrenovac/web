package model;

import controllers.Start;
import db.DBconn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoryDAO {

    public static List getAll() {
        List<Category> listAll = new ArrayList<Category>();
        Category c;

        Connection conn = DBconn.getConnection();
        Statement st;
        try {
            st = conn.createStatement();

            st.executeQuery("select * from categories");
            ResultSet rs = st.getResultSet();

            while (rs.next()) {
                c = new Category();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                listAll.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listAll;
    }

    public static void insert(String name) {
        try {
            Connection conn = DBconn.getConnection();
            PreparedStatement st = conn.prepareStatement("insert into categories (id, name) values (null, '"+name+"')");
            st.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void delete (int id){
        Connection conn = DBconn.getConnection();
            PreparedStatement st;
        try {
            st = conn.prepareStatement("delete from categories where id=" + id);
            st.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
}
