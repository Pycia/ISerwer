package pl.edu.pk.cyberMama.model;

import com.mongodb.ReflectionDBObject;

/**
 * Created by Nati on 30.03.14.
 */
public class User extends ReflectionDBObject {
    private String login;
    private String passwordHash;

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getLogin() {
        return login;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public User(String login, String lasswordHash) {

        this.login = login;
        this.passwordHash = lasswordHash;
    }
}