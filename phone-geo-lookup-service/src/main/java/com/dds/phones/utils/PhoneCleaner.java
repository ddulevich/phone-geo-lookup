package com.dds.phones.utils;

public class PhoneCleaner {

    public static final String EMPTY_STRING = "";

    public static String cleanPhoneNumber(final String phone){
        return phone
                .replaceAll("\\+", EMPTY_STRING)
                .replaceAll("\\(", EMPTY_STRING)
                .replaceAll("\\)", EMPTY_STRING)
                .replaceAll("\\.", EMPTY_STRING)
                .replaceAll("-", EMPTY_STRING)
                .replaceAll(" ", EMPTY_STRING);
    }
}
