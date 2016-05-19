package com.moss.serializators;

import java.util.ArrayList;

import com.moss.model.Login;

public abstract class Serializator {

    public long testWrite(ArrayList<Login> logins) {
        long start = System.currentTimeMillis();
        serialize(logins);
        long end = System.currentTimeMillis();
        return (end - start);
    }

    public long testRead(ArrayList<Login> logins) {
        long start = System.currentTimeMillis();
        deserialize();
        long end = System.currentTimeMillis();
        return (end - start);
    }

    protected abstract void serialize(ArrayList<Login> logins);

    protected abstract ArrayList<Login> deserialize();

}
