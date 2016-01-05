package DB;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;

/*
 * This class is used to connect to MySQL Database. It also includes methods
 * for preparing query statements and closing existing connections. 
 */
/**
 *
 * @author aben
 */
public class DBConnect {

    private Connection con;
    public PreparedStatement statement;
    private String query;

    public DBConnect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "pass");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error:" + e);
        }
    }

    public void newQuery(String sql) throws Exception {
        query = sql;
        statement = con.prepareStatement(query);
    }

    public void closeConnection() {
        try {
            if (statement != null) {
                statement.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
}
