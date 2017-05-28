package model;

import db.DBconn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAO {

    public static void insert(User u) {
        try {
            Connection conn = DBconn.getConnection();
            PreparedStatement st = conn.prepareStatement("insert into users(first_name, last_name, username, vallet, password, role) values (?,?,?,?,?,?)");
            st.setString(1, u.getFirstName());
            st.setString(2, u.getLastName());
            st.setString(3, u.getUsername());
            st.setDouble(4, u.getVallet());
            st.setString(5, u.getPassword());
            st.setInt(6, u.getRole());
            st.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public User select(String username, String password) throws SQLException {

        User user = new User();
        Connection conn = DBconn.getConnection();
        PreparedStatement st = conn.prepareStatement("select * from users where username='" + username + "' and password='" + password + "'");
        st.execute();
        ResultSet rs = st.getResultSet();
        while (rs.next()) {
            user.setId(rs.getInt("id"));
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));
            user.setUsername(rs.getString("username"));
            user.setVallet(rs.getDouble("vallet"));
            user.setPurchases(rs.getInt("purchases"));
            user.setPassword(rs.getString("password"));
        }
        return user;
    }
    
    public User selectById (int id) throws SQLException {

        User user = new User();
        Connection conn = DBconn.getConnection();
        PreparedStatement st = conn.prepareStatement("select * from users where id="+id);
        st.execute();
        ResultSet rs = st.getResultSet();
        while (rs.next()) {
            user.setId(rs.getInt("id"));
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));
            user.setUsername(rs.getString("username"));
            user.setVallet(rs.getDouble("vallet"));
            user.setPurchases(rs.getInt("purchases"));
            user.setPassword(rs.getString("password"));
        }
        return user;
    }

    public static void updateFunds(double vallet, int id) {
        try {
            Connection conn = DBconn.getConnection();
            PreparedStatement st = conn.prepareStatement("update users set vallet=" + vallet + " where id=" + id);
            st.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static List<User> searchBy(String param, String search) {
        List<User> all = new ArrayList<User>();
        try {
            Connection conn = DBconn.getConnection();
            PreparedStatement st = conn.prepareStatement("select * from users where " + param + "='" + search + "'");
            st.execute();
            ResultSet rs = st.getResultSet();
            while (rs.next()) {
                User user = new User(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("username"), rs.getDouble("vallet"), rs.getInt("purchases"), rs.getString("password"), rs.getInt("role"));
                all.add(user);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return all;
    }

    public void delete(int id) {
        try {
            Connection conn = DBconn.getConnection();
            PreparedStatement st = conn.prepareStatement("delete from users where id=" + id);
            st.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateUser(int id, User user) {
        try {
            Connection conn = DBconn.getConnection();
            PreparedStatement st = conn.prepareStatement("update users set first_name='"+user.getFirstName()+"', last_name='"+user.getLastName()+"', username='"+user.getUsername()+"', password='"+user.getPassword()+"', vallet="+user.getVallet()+", role="+user.getRole()+" where id=" + id);
            st.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
