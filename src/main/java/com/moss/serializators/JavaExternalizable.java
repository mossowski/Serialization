package com.moss.serializators;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.moss.model.LoginExt;

public class JavaExternalizable {

    final String FILE_NAME = "externalizable";

    public void serialize(ArrayList<LoginExt> logins) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(logins);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<LoginExt> deserialize() {
        ArrayList<LoginExt> result = new ArrayList<LoginExt>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            result = (ArrayList<LoginExt>) in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    public long testWrite(ArrayList<LoginExt> logins) {
        long start = System.currentTimeMillis();
        serialize(logins);
        long end = System.currentTimeMillis();
        return (end - start);
    }

    public long testRead(ArrayList<LoginExt> logins) {
        long start = System.currentTimeMillis();
        deserialize();
        long end = System.currentTimeMillis();
        return (end - start);
    }

}
