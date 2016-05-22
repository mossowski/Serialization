package com.moss.serializators;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.JsonIOException;
import com.moss.model.Login;

public class Gson extends Serializator {

    final String FILE_NAME = "gson.json";

    @Override
    protected void serialize(ArrayList<Login> logins) {
        com.google.gson.Gson gson = new com.google.gson.Gson();
        try {
            String json = gson.toJson(logins);
            FileWriter writer = new FileWriter(FILE_NAME);
            writer.write(json);
            writer.close();
        } catch (JsonIOException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected ArrayList<Login> deserialize() {
        com.google.gson.Gson gson = new com.google.gson.Gson();
        ArrayList<Login> result = new ArrayList<Login>();
        try {
            result = gson.fromJson(new FileReader(FILE_NAME), ArrayList.class);
        } catch (JsonIOException | IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
