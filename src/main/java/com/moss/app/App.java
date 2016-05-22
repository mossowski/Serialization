package com.moss.app;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.moss.model.Data;
import com.moss.model.Login;
import com.moss.model.LoginSerial;
import com.moss.model.LoginExt;
import com.moss.serializators.JavaExternalizable;
import com.moss.serializators.Gson;
import com.moss.serializators.Jackson;
import com.moss.serializators.JavaSerializable;
import com.moss.serializators.Serializator;

public class App {

    private final int numberOfTests = 1000;
    private List<Serializator> serializators = new ArrayList<Serializator>();
    private ArrayList<ArrayList<Login>> logins = new ArrayList<ArrayList<Login>>();
    private ArrayList<ArrayList<LoginSerial>> loginsSerial = new ArrayList<ArrayList<LoginSerial>>();
    private ArrayList<ArrayList<LoginExt>> loginsExt = new ArrayList<ArrayList<LoginExt>>();

    public App() {
        logins = Data.prepareData(Login.class);
        loginsSerial = Data.prepareData(LoginSerial.class);
        loginsExt = Data.prepareData(LoginExt.class);

        serializators.add(new Jackson());
        serializators.add(new Gson());
    }

    public void testSerializers() {
        for (Serializator serializator : serializators) {
            for (ArrayList<Login> loginArray : logins) {
                long processingTime = 0;
                for (int i = 0; i < numberOfTests; i++) {
                    processingTime += serializator.testWrite(loginArray);
                    processingTime += serializator.testRead(loginArray);
                }
                float avgTime = processingTime / numberOfTests;
                System.out.println(serializator.getClass().toString() + " Processing time : " + avgTime);
            }
        }

        JavaSerializable javaSerializable = new JavaSerializable();
        for (ArrayList<LoginSerial> loginArray : loginsSerial) {
            long processingTime = 0;
            for (int i = 0; i < numberOfTests; i++) {
                processingTime += javaSerializable.testWrite(loginArray);
                processingTime += javaSerializable.testRead(loginArray);
            }
            float avgTime = processingTime / numberOfTests;
            System.out.println(javaSerializable.getClass().toString() + " Processing time : " + avgTime);
        }

        JavaExternalizable javaExternalizable = new JavaExternalizable();
        for (ArrayList<LoginExt> loginArray : loginsExt) {
            long processingTime = 0;
            for (int i = 0; i < numberOfTests; i++) {
                processingTime += javaExternalizable.testWrite(loginArray);
                processingTime += javaExternalizable.testRead(loginArray);
            }
            float avgTime = processingTime / numberOfTests;
            System.out.println(javaExternalizable.getClass().toString() + " Processing time : " + avgTime);
        }
    }

}
