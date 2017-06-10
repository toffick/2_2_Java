package Lib;

/**
 * Created by DELL on 16.04.2017.
 */
public class Book {
    String bookname;
    String authorname;
    int year;
    String phouse;

    public Book()
    {};

    public Book(String _n, String _a, int _y, String _p)
    {
        bookname = _n;
        authorname = _a;
        year = _y;
        phouse = _p;
    }

    public String getBookName()
    {
        return bookname;
    }
    @Override
    public String toString() {
        return "Book{" +
                "bookname='" + bookname  +", authorname='" + authorname  +", year=" + year +", phouse='" + phouse  +
                '}';
    }
}
