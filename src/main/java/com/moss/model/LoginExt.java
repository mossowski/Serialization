package com.moss.model;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class LoginExt extends Login implements Externalizable {

    public LoginExt() {

    }

    public LoginExt(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean equals(Object object) {
        LoginExt login = (LoginExt) object;
        if (password.equals(login.getPassword())) {
            if (username.equals(login.getUsername())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(username);
        out.writeObject(password);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        username = (String) in.readObject();
        password = (String) in.readObject();
    }

}
