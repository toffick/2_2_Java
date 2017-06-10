package by.belstu.it.Borsuk.basejava;

/**
 * Created by ACER on 06.02.2017.
 */
public class WrapperString {
    /**@author NIKLS */
    /**@version 1.0*/
    private String str;

    public String getStr() {
        return str;

    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WrapperString that = (WrapperString) o;

        return str != null ? str.equals(that.str) : that.str == null;
    }

    @Override
    public int hashCode() {
        return str != null ? str.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "WrapperString{" +
                "str='" + str + '\'' +
                '}';
    }

    public WrapperString(String str) {
        this.str = str;

    }

    public void replace (char oldchar, char newchar)
    {
        this.setStr(str.replace(oldchar,newchar));
    }


}