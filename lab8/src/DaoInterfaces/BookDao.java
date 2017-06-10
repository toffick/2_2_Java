package DaoInterfaces;


import Lib.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by DELL on 16.04.2017.
 */
public interface BookDao {

    Book read(String key) throws SQLException;

    void delete(String bname) throws SQLException;

    List<Book> getAll() throws SQLException;

    List<Book> getBookInYear(int y) throws SQLException;

    void deleteBookInYear(int y) throws SQLException;

}
