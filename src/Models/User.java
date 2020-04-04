package Models;

import java.io.Serializable;

public class User implements Serializable
{
    private String name;
    private String email;

    public User() {}
    public User(String name , String email)
    {
        setName(name);
        setEmail(email);
    }

    private void setName(String name) { this.name = name; }
    private void setEmail(String email) { this.email = email; }

    public String getName() { return name; }
    public String getEmail() { return email; }
}
