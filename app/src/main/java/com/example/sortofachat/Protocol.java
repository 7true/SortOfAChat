package com.example.sortofachat;

public class Protocol {
    public static final int USER_STATUS = 1;//status (online/offline)
    public static final int MESSAGE = 2;
    public static final int USER_NAME = 3;

    static class User {
        private long id;
        private String name;
    }

    static class UserStatus {
        private boolean connected;
    }

}
