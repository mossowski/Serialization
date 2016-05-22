package com.moss.serializators;

import java.util.ArrayList;

import com.moss.model.Login;

public abstract class Serializator {

    public <T extends Login> long testWrite(ArrayList<T> logins) {
        long start = System.currentTimeMillis();
        serialize(logins);
        long end = System.currentTimeMillis();
        return (end - start);
    }

    public <T extends Login> long testRead(ArrayList<T> logins) {
        long start = System.currentTimeMillis();
        deserialize();
        long end = System.currentTimeMillis();
        return (end - start);
    }

    protected abstract <T extends Login> void serialize(ArrayList<T> logins);

    protected abstract <T extends Login> ArrayList<T> deserialize();

}
