package com.mootiv.error;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class ApiErrorResponse {
    private String uri;
    private LocalDateTime timestamp;
    private List<ApiError> error;

    public ApiErrorResponse(String uri, LocalDateTime timestamp, List<ApiError> error) {
        this.uri = uri;
        this.timestamp = timestamp;
        this.error = error;
    }

}
