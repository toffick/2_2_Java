package DaoInterfaces;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by DELL on 16.04.2017.
 */
public interface DaoFactory {

     Connection getConnection() throws SQLException;

    BookDao getBookDao() throws SQLException;

    AuthorDao getAuthorDao() throws SQLException;

    void close();

}
