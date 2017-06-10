package DaoClass;

import DaoInterfaces.AuthorDao;
import Lib.Author;
import Lib.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 16.04.2017.
 */
public class AuthorDaoC implements AuthorDao {
    private final Connection connection;



    @Override
    public Author read(String key) throws SQLException {
        String sqlq = "SELECT * FROM AUTHOR WHERE AUTHORNAME = ?";
        PreparedStatement stm = connection.prepareStatement(sqlq);
        stm.setString(1, key);
        ResultSet rs = stm.executeQuery();

        return rs.next()?new Author(rs.getString(1), rs.getString(2)):null;
    }



    @Override
    public void delete(String group) {
        String sqlq = "SELECT * FROM AUTHOR WHERE AUTHORNAME = ?";
        try(PreparedStatement stm = connection.prepareStatement(sqlq)) {
            stm.setString(1, group);

            int count = stm.executeUpdate();
            if(count!=1)
                throw new Exception("Все хреново, друг. Пока");
            stm.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public List<Author> getAll() throws SQLException {
        List<Author> retlist = new ArrayList<>();

        String sqlq = "SELECT * FROM AUTHOR ";
       try( Statement stm = connection.createStatement()) {
           ResultSet rs = stm.executeQuery(sqlq);
           while (rs.next()) {
               retlist.add(new Author(rs.getString(1), rs.getString(2)));
           }
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
        return retlist;
    }

    @Override
    public List<Author> getAllnBook(int n) throws SQLException {
        List<Author> retlist = new ArrayList<>();

        String sqlq = "select AUTHOR.authorname,AUTHOR.COUNTRY from \n" +
                "author inner join BOOK\n" +
                "on BOOK.AUTHORNAME = AUTHOR.AUTHORNAME\n" +
                "group by AUTHOR.authorname,AUTHOR.COUNTRY \n" +
                "having count(*) >=?";

        try(PreparedStatement stm = connection.prepareStatement(sqlq)) {
            stm.setInt(1, n);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                retlist.add(new Author(rs.getString(1), rs.getString(2)));
            }
        }
        return retlist;
    }



    public AuthorDaoC(Connection _connection)
    {
        connection = _connection;
    }

}
