package com.moss.app;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.moss.model.Login;
import com.moss.model.LoginExt;
import com.moss.serializators.JavaExternalizable;
import com.moss.serializators.Gson;
import com.moss.serializators.Jackson;
import com.moss.serializators.JavaSerializable;
import com.moss.serializators.Serializator;

public class App {

    private int numberOfTests = 1000;
    private List<Serializator> serializators = new ArrayList<Serializator>();
    private ArrayList<ArrayList<Login>> logins = new ArrayList<ArrayList<Login>>();

    public App() {
        serializators.add(new JavaSerializable());
        serializators.add(new Jackson());
        serializators.add(new Gson());
        ArrayList<Login> login1 = new ArrayList<Login>();
        ArrayList<Login> login10 = new ArrayList<Login>();
        ArrayList<Login> login10000 = new ArrayList<Login>();

        for (int i = 0; i < 10000; i++) {
            String randomLogin = UUID.randomUUID().toString();
            String randomPassword = UUID.randomUUID().toString();
            Login login = new Login(randomLogin, randomPassword);

            if (i < 1)
                login1.add(login);
            if (i < 10)
                login10.add(login);

            login10000.add(login);
        }
        logins.add(login1);
        logins.add(login10);
        logins.add(login10000);
    }

    public void testSerializers() {
        for (ArrayList<Login> loginArray : logins) {
            for (Serializator serializator : serializators) {
                long processingTime = 0;
                for (int i = 0; i < numberOfTests; i++) {
                    processingTime += serializator.testWrite(loginArray);
                }
                float avgTime = processingTime / numberOfTests;
                System.out.println(serializator.getClass().toString() + " Processing time : " + avgTime);
            }
        }
    }

}
