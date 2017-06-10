package Lib;

/**
 * Created by DELL on 16.04.2017.
 */
public class Author {
    String authorname;
    String country;

    public Author(){}

    public Author(String _n, String _c)
    {
        authorname = _n;
        country = _c;
    }
    public String getAuthorName()
    {
        return authorname;
    }
    @Override
    public String toString() {
        return "Author{" +
                "authorname='" + authorname + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
