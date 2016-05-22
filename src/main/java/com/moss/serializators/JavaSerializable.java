package com.moss.serializators;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.moss.model.LoginSerial;

public class JavaSerializable {

    final String FILE_NAME = "serializable";

    public void serialize(ArrayList<LoginSerial> logins) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(logins);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<LoginSerial> deserialize() {
        ArrayList<LoginSerial> result = new ArrayList<LoginSerial>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            result = (ArrayList<LoginSerial>) in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    public long testWrite(ArrayList<LoginSerial> logins) {
        long start = System.currentTimeMillis();
        serialize(logins);
        long end = System.currentTimeMillis();
        return (end - start);
    }

    public long testRead(ArrayList<LoginSerial> logins) {
        long start = System.currentTimeMillis();
        deserialize();
        long end = System.currentTimeMillis();
        return (end - start);
    }

}
