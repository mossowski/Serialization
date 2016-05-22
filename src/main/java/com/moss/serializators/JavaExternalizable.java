package com.moss.serializators;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.moss.model.Login;

public class JavaExternalizable extends Serializator {

    final String FILE_NAME = "externalizable";

    public <T extends Login> void serialize(ArrayList<T> logins) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(logins);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public <T extends Login> ArrayList<T> deserialize() {
        ArrayList<T> result = new ArrayList<T>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            result = (ArrayList<T>) in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

}
