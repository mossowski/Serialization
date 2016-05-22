package com.moss.model;

public class Login {

    protected String username;
    protected String password;

    public Login() {

    }

    public Login(String username, String password) {
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

    public boolean equals(Object object) {
        Login login = (Login) object;
        if (password.equals(login.getPassword())) {
            if (username.equals(login.getUsername())) {
                return true;
            }
        }
        return false;
    }

}
