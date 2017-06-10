package by.bstu.poit.sinitsa.models;

/**
 * Created by kleap on 20.05.2017.
 */
public class User {
    private String login;
    private String password;
    private String role;

    public User(String login, String password, String role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }
}
