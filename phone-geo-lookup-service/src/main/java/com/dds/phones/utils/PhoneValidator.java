package com.dds.phones.utils;

import java.util.regex.Pattern;

public class PhoneValidator {
    public static final String PHONE_NUMBER_PATTERN = "^\\+?\\d{1,4}?[-.\\s]?\\(?\\d{1,3}?\\)?[-.\\s]?\\d{1,4}[-.\\s]?\\d{1,4}[-.\\s]?\\d{1,9}$";

    public static void validatePhoneNumber(final String phone){
        final Pattern pattern = Pattern.compile(PHONE_NUMBER_PATTERN);
        if (!pattern.matcher(phone).matches()){
            throw new RuntimeException("Invalid phone number");
        }
    }
}
