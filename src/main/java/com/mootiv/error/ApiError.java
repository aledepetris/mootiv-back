package com.mootiv.error;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ApiError {

    @JsonProperty
    private String errorCode;
    @JsonProperty
    private String errorMessage;
    @JsonIgnore
    private String logMessage;

    public ApiError(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public ApiError(String errorCode, String errorMessage, String logMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.logMessage = logMessage;
    }

}
