package com.luv2code.springdemo.representation;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiResponse<T> {
    private long code;
    private T data;

    public ApiResponse() {
        // Jackson deserialization
    }

    public ApiResponse(long code, T data) {
        this.code = code;
        this.data = data;
    }

    @JsonProperty
    public long getCode() {
        return code;
    }

    @JsonProperty
    public T getData() {
        return data;
    }


}