package com.mootiv.error.exception;

import com.mootiv.error.ApiError;
import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {

    private final transient ApiError apiError;

    public BaseException(ApiError apiError) {
        super(apiError.getErrorMessage());
        this.apiError = apiError;
    }

}
