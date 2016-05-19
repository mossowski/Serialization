package com.moss.serializators;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moss.model.Login;

public class Jackson extends Serializator {

    final String FILE_NAME = "jackson.json";

    @Override
    protected void serialize(ArrayList<Login> logins) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(FILE_NAME), logins);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected ArrayList<Login> deserialize() {
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<Login> logins = new ArrayList<Login>();
        try {
            logins = mapper.readValue(new File(FILE_NAME), ArrayList.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return logins;
    }

}
