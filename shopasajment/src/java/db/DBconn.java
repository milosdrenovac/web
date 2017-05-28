package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBconn {
    private static Connection connect;
    
    public static Connection getConnection(){
        if(connect==null){
            try {
                connect = DriverManager.getConnection("jdbc:mysql://localhost/shop","root","");
            } catch (SQLException ex) {
                Logger.getLogger(DBconn.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return connect;
    }
    
}
