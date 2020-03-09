package com.webservice.dexter_service.Model.Validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class DataValidator {

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public static String getEmailPattern() {
        return EMAIL_PATTERN;
    }

    public static Boolean validateEmail(final String email){
        Pattern pattern;
        Matcher matcher;

        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
