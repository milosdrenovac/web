package model;

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

public class PurchaseDAO {

    public void insert(Purchase p) {
        try {
            Connection conn = DBconn.getConnection();
            PreparedStatement st = conn.prepareStatement("insert into purchases(user, total_price, date) values (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, p.getUser());
            st.setDouble(2, p.getTotalPrice());
            st.setDate(3, new java.sql.Date(p.getDate().getTime()));
            st.execute();

            ResultSet rs = st.getGeneratedKeys();
            while (rs.next()) {
                p.setId(rs.getInt(1));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static List<Purchase> select(int userId) throws SQLException {

        List<Purchase> list = new ArrayList<Purchase>();
        Connection conn = DBconn.getConnection();
        PreparedStatement st = conn.prepareStatement("select * from purchases where user=" + userId);
        st.execute();
        Purchase p;
        ResultSet rs = st.getResultSet();
        while (rs.next()) {
            p = new Purchase(rs.getInt("user"), rs.getDouble("total_price"), rs.getDate("date"));
            p.setId(rs.getInt(1));
            list.add(p);
        }
        return list;
    }
}
