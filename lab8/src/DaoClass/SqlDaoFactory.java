package DaoClass;

import DaoInterfaces.AuthorDao;
import DaoInterfaces.BookDao;
import DaoInterfaces.DaoFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;

/**
 * Created by DELL on 16.04.2017.
 */
public class SqlDaoFactory implements DaoFactory {

   static String URL ="jdbc:sqlserver://DESKTOP-FFV5E68\\SQLEXPRESS;integratedSecurity=true;databaseName=JAVA";

    static public SqlDaoFactory instance;

    private Connection connection;

    private SqlDaoFactory() throws SQLException {
    }

    public  static SqlDaoFactory getInstance() throws SQLException {
        if(instance==null)
        {
            instance = new SqlDaoFactory();

        }
        return instance;
    }

    public void setAutoCimmitFalse()
    {
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Savepoint createSavepoint(String s) throws SQLException {
        return connection.setSavepoint(s);
    }

    public void commit() throws SQLException {
        connection.commit();
    }
    public void rollback(Savepoint sp) throws SQLException {
        connection.rollback(sp);
    }

    @Override
    public Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(URL);
        }
        return connection;
    }
    @Override
    public BookDao getBookDao() throws SQLException {
        return new BookDaoC(getConnection());
    }

    @Override
    public AuthorDao getAuthorDao() throws SQLException {
        return new AuthorDaoC(getConnection());

    }

    @Override
    public void close() {
        try
        {
            connection.close();
        }
        catch(SQLException ee)
        {
            ee.printStackTrace();
        }
    }


}
