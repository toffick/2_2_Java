import DaoClass.AuthorDaoC;
import DaoClass.BookDaoC;
import DaoClass.SqlDaoFactory;
import DaoInterfaces.AuthorDao;
import DaoInterfaces.BookDao;
import Lib.Author;
import Lib.Book;

import java.sql.SQLException;
import java.sql.Savepoint;

/**
 * Created by DELL on 16.04.2017.
 */
public class Main {
    public static void main(String[] args) {
        SqlDaoFactory sdf = null;
        try {

            sdf = SqlDaoFactory.getInstance();

            BookDaoC bookdao = new BookDaoC(sdf.getConnection());
            AuthorDaoC authorDao = new AuthorDaoC(sdf.getConnection());


            System.out.println("Книги за 1917 и 1916 года");
            for(Book ss : bookdao.getBookInYear(1917))
            {
                System.out.println(ss);
            }

            System.out.println("\nИнформация об авторах");
            for(Author ss : authorDao.getAll())
            {
                System.out.println(ss);
            }

            System.out.println("\nАвторы с n+ книг");
            for(Author ss : authorDao.getAllnBook(2))
            {
                System.out.println(ss);
            }



            System.out.println("\nКниги ДО удаления");
            for(Book ss : bookdao.getAll())
            {
                System.out.println(ss);
            }

            sdf.setAutoCimmitFalse();
            Savepoint savepoint = sdf.createSavepoint("SavepointOne");

            bookdao.deleteBookInYear(1);

            System.out.println("\nКниги ПОСЛЕ удаления");
            for(Book ss : bookdao.getAll())
            {
                System.out.println(ss);
            }
            sdf.rollback(savepoint);
            System.out.println("\nКниги ПОСЛЕ ROLLBACK");
            for(Book ss : bookdao.getAll())
            {
                System.out.println(ss);
            }




            sdf.close();



        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}

