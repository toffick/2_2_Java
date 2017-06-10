package DataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by DELL on 24.05.2017.
 */
public class Query {
    public static String getUserType(String log, String pass) {
        String type = "Null";
        Connection connection = DataBaseConnection.getConnection();
        try {
            Statement stat = connection.createStatement();
            ResultSet resultSet = stat.executeQuery("select * from users");
            while (resultSet.next()) {
                if (log.equals(resultSet.getString(1)) && pass.equals(resultSet.getString(2))) {
                    type = resultSet.getString(3);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return type;
        }

        }

    public static void regUser(String login, String pass){
        Connection connection = DataBaseConnection.getConnection();
        try {
            Statement statement = connection.createStatement();
            String query = "insert into users values (\'"+login+"\',\'"+pass+"\', \'user\');";
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
