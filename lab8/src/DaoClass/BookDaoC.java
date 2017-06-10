package DaoClass;

import DaoInterfaces.BookDao;
import Lib.Book;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 16.04.2017.
 */
public class BookDaoC implements BookDao {
    private final Connection connection;

    @Override
    public Book read(String key) throws SQLException {
        String sqlq = "SELECT * FROM BOOK WHERE BOOKNAME = ?";
       PreparedStatement stm = connection.prepareStatement(sqlq);
        stm.setString(1, key);
        ResultSet rs = stm.executeQuery();

        return rs.next()?new Book(rs.getString(1), rs.getString(2), rs.getInt(3),
                rs.getString(4)):null;
    }

    @Override
    public void delete(String bname) throws SQLException {

        String sqlq = "SELECT * FROM BOOK WHERE BOOKNAME = ?";
        try(PreparedStatement stm = connection.prepareStatement(sqlq)) {
            stm.setString(1, bname);

            int count = stm.executeUpdate();

            stm.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Book> getAll() throws SQLException {
        List<Book> retlist = new ArrayList<>();

        String sqlq = "SELECT * FROM BOOK ";
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery(sqlq);
        while(rs.next())
        {
            retlist.add(new Book(rs.getString(1), rs.getString(2), rs.getInt(3),
                    rs.getString(4)));
        }
        return retlist;
    }

    @Override
    public List<Book> getBookInYear(int y) throws SQLException {
        List<Book> retlist = new ArrayList<>();

        String sqlq = "SELECT * FROM BOOK where year in (?,?)";
        ResultSet rs;

        try(PreparedStatement stm = connection.prepareStatement(sqlq))
        {
            stm.setInt(1,y);
            stm.setInt(2,y-1);

            rs = stm.executeQuery();
            while(rs.next())
            {
                retlist.add(new Book(rs.getString(1), rs.getString(2), rs.getInt(3),
                        rs.getString(4)));
            }
            stm.close();
        }

    return retlist;
    }

    @Override
    public void deleteBookInYear(int y) throws SQLException {

        String sqlq = "DELETE FROM BOOK " +
                "WHERE YEAR > ?;";
        try(PreparedStatement stm = connection.prepareStatement(sqlq))
        {
            stm.setInt(1,y);
            stm.executeUpdate();
            stm.close();
        }
    }



    public BookDaoC(Connection _connection)
    {
        connection = _connection;
    }



}
