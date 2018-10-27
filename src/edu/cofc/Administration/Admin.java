package edu.cofc.Administration;

public class Admin {

    private String password;
    private String username;

    public Admin(String pass, String user){
        this.password = pass;
        this.username = user;
    }

    public void setPassword(String pass) {
        this.password = pass;
    }

    public void setUsername(String user) {
        this.username = user;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUsername() {
        return this.username;
    }
}
