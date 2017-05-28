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

public class ItemDAO {

    public static List getAll() {
        List<Item> listAll = new ArrayList<Item>();
        Item i;

        Connection conn = DBconn.getConnection();
        Statement st;
        try {
            st = conn.createStatement();

            st.executeQuery("select * from items");
            ResultSet rs = st.getResultSet();

            while (rs.next()) {
                i = new Item();
                i.setId(rs.getInt("id"));
                i.setName(rs.getString("name"));
                i.setDescription(rs.getString("description"));
                i.setPrice(rs.getDouble("price"));
                i.setImage(rs.getString("image"));
                i.setCategory(rs.getInt("category"));
                i.setQuantity(rs.getInt("quantity"));
                listAll.add(i);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listAll;
    }

    public static Item get(int id) {
        Item item = new Item();
        try {
            Connection conn = DBconn.getConnection();
            PreparedStatement st = conn.prepareStatement("select * from items where id=" + id);
            st.execute();
            ResultSet rs = st.getResultSet();
            while (rs.next()) {
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setDescription(rs.getString("description"));
                item.setPrice(rs.getDouble("price"));
                item.setImage(rs.getString("image"));
                item.setCategory(rs.getInt("category"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return item;
    }
    
    public Item getByName(String name) {
        Item item = new Item();
        try {
            Connection conn = DBconn.getConnection();
            PreparedStatement st = conn.prepareStatement("select * from items where name='" + name +"'");
            st.execute();
            ResultSet rs = st.getResultSet();
            while (rs.next()) {
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setDescription(rs.getString("description"));
                item.setPrice(rs.getDouble("price"));
                item.setImage(rs.getString("image"));
                item.setCategory(rs.getInt("category"));
                item.setQuantity(rs.getInt("quantity"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return item;
    }

    public void insert(Item item) {
        try {
            Connection conn = DBconn.getConnection();
            PreparedStatement st = conn.prepareStatement("insert into items(id, name, description, price, image, category, quantity) values (null,?,?,?,?,?,?)");
            
            st.setString(1, item.getName());
            st.setString(2, item.getDescription());
            st.setDouble(3, item.getPrice());
            st.setString(4, item.getImage());
            st.setInt(5, item.getCategory());
            st.setInt(6, item.getQuantity());
            st.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete (int id){
        Connection conn = DBconn.getConnection();
            PreparedStatement st;
        try {
            st = conn.prepareStatement("delete from items where id=" + id);
            st.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateItem(int id, Item item) {
        try {
            Connection conn = DBconn.getConnection();
            PreparedStatement st = conn.prepareStatement("update items set name='"+item.getName()+"', description='"+item.getDescription()+"', price='"+item.getPrice()+"', image='"+item.getImage()+"', category="+item.getCategory()+", quantity="+item.getQuantity()+" where id=" + id);
            st.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //select items.id from items join purchase_item on items.id = purchase_item.item join purchases on purchases.id=purchase_item.purchase where purchase_item.purchase=15;
    
    public List<Item> selectFromPurchases(int purchaseId) throws SQLException {
        
        Connection conn = DBconn.getConnection();
        PreparedStatement st = conn.prepareStatement("select items.id, items.name, items.description, items.price, items.image, items.category, items.quantity from items join purchase_item on items.id = purchase_item.item join purchases on purchases.id=purchase_item.purchase where purchase_item.purchase=" + purchaseId);
        st.execute();
        ResultSet rs = st.getResultSet();
        
        List <Item> list = new ArrayList<>();
        Item item;
        while (rs.next()){
           item = new Item(rs.getString("name"), rs.getString("description"), rs.getDouble("price"), rs.getString("image"), rs.getInt("category"), rs.getInt("quantity"));
           item.setId(rs.getInt(1));
           list.add(item);
        }
        
        return list;
    }
}
