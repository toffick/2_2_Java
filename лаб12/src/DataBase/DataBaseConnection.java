package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by DELL on 24.05.2017.
 */
public class DataBaseConnection {

    static String URL ="jdbc:sqlserver://DESKTOP-FFV5E68\\SQLEXPRESS;integratedSecurity=true;databaseName=java_12_servlet";


    private static Connection connection;

    public  static Connection getConnection(){

        try {
            return DriverManager.getConnection(URL);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}
