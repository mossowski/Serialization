package com.moss.model;

import java.io.Serializable;

public class LoginSerial extends Login implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public LoginSerial(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean equals(Object object) {
        LoginSerial login = (LoginSerial) object;
        if (password.equals(login.getPassword())) {
            if (username.equals(login.getUsername())) {
                return true;
            }
        }
        return false;
    }

}
