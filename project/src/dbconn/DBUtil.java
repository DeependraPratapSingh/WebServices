/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconn;

import java.sql.*;
/**
 *
 * @author Rishabh
 */
public class DBUtil {
    
    static Connection conn = null;
    
    public static Connection createConnection()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/abc","root","mysql");
            return conn;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return conn;
    }
    
}
