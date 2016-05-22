package com.moss.serializators;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

import com.moss.model.Login;

public abstract class Serializator {

    public <T extends Login> double testWrite(ArrayList<T> logins) {
        Instant before = Instant.now();
        serialize(logins);
        Instant after = Instant.now();
        double delta = Duration.between(before, after).toMillis();
        return delta;
    }

    public <T extends Login> double testRead(ArrayList<T> logins) {
        Instant before = Instant.now();
        deserialize();
        Instant after = Instant.now();
        double delta = Duration.between(before, after).toMillis();
        return delta;
    }

    protected abstract <T extends Login> void serialize(ArrayList<T> logins);

    protected abstract <T extends Login> ArrayList<T> deserialize();

}
