package model;

import db.DBconn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PurchaseItemDAO {

    public void insert(PurchaseItem pi) {
        try {
            Connection conn = DBconn.getConnection();
            PreparedStatement st = conn.prepareStatement("insert into purchase_item (purchase, item) values (?,?)");
            st.setInt(1, pi.getPurchase());
            st.setInt(2, pi.getItem());
            st.execute();

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
