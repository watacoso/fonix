package com.fonix.util;

public enum Regex {



    EMAIL_PATTERN("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,}$");


    private String pattern;

    Regex(String pattern){
        this.pattern=pattern;
    }

    public String getPattern() {
        return pattern;
    }
}
