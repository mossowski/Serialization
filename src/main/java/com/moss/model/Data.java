package com.moss.model;

import java.util.ArrayList;
import java.util.UUID;

public class Data {

    private final static int FIRST_TEST_SIZE = 1;
    private final static int SECOND_TEST_SIZE = 10;
    private final static int THIRD_TEST_SIZE = 10000;

    public static <T extends Login> ArrayList<ArrayList<T>> prepareData(Class<T> type) {
        ArrayList<ArrayList<T>> result = new ArrayList<ArrayList<T>>();
        for (int i = 0; i < 3; i++) {
            ArrayList<T> logins = new ArrayList<T>();
            int testSize;
            if (i == 0) {
                testSize = FIRST_TEST_SIZE;
            } else if (i == 1) {
                testSize = SECOND_TEST_SIZE;
            } else {
                testSize = THIRD_TEST_SIZE;
            }
            for (int j = 0; j < testSize; j++) {
                String randomLogin = UUID.randomUUID().toString();
                String randomPassword = UUID.randomUUID().toString();
                String className = type.getName();
                if (className.contains("LoginSerial")) {
                    logins.add((T) new LoginSerial(randomLogin, randomPassword));
                } else if (className.contains("LoginExt")) {
                    logins.add((T) new LoginExt(randomLogin, randomPassword));
                } else {
                    logins.add((T) new Login(randomLogin, randomPassword));
                }
            }
            result.add(logins);
        }
        return result;
    }

}
