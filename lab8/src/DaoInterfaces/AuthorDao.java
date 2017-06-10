package DaoInterfaces;


import Lib.Author;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by DELL on 16.04.2017.
 */
public interface AuthorDao {


     Author read(String key) throws SQLException;

     void delete(String group) throws SQLException;

     List<Author> getAll() throws SQLException;

     List<Author> getAllnBook(int n) throws SQLException;



}
