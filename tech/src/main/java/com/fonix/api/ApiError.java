package com.fonix.api;

public class ApiError {

    private final String detail;

    public ApiError(String detail) {
        this.detail = detail;
    }

    public String getDetail() {
        return detail;
    }
}
