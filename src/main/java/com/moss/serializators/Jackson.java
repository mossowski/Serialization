package com.moss.serializators;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moss.model.Login;

public class Jackson extends Serializator {

    final String FILE_NAME = "jackson.json";

    @Override
    protected <T extends Login> void serialize(ArrayList<T> logins) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(FILE_NAME), logins);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected <T extends Login> ArrayList<T> deserialize() {
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<T> logins = new ArrayList<T>();
        try {
            logins = mapper.readValue(new File(FILE_NAME), ArrayList.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return logins;
    }

}
