package dto;

import java.io.Serializable;

/**
 * Created by User on 20.08.2016.
 */
public class CASUser implements Serializable {

    private String username;
    private String password;

    public CASUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}