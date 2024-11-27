package com.example.demo.helper;

import java.util.regex.Pattern;

public class StringHelper {

    private static final String PH_MOBILE_REGEX = "^(?:\\+63|0)9\\d{9}$";
    private static final String EMAIL_REGEX = "^[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
    
    public Boolean isEmptyString(String str){ 
        if(str == null || str.length() == 0 )
        { 
            return true;
        }

        return false; 
    } 

    public Boolean isValidMobile(String str){ 
        Pattern pattern = Pattern.compile(PH_MOBILE_REGEX);
        return pattern.matcher(str).matches();
    }


    public Boolean isValidEmail(String str){ 
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        return pattern.matcher(str).matches();
    }
}

