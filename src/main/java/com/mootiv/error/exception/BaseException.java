package com.mootiv.error.exception;

import com.mootiv.error.ApiError;
import lombok.Getter;

import java.util.function.Supplier;

@Getter
public class BaseException extends RuntimeException {

    private final ApiError apiError;

    public BaseException(ApiError apiError) {
        super(apiError.getErrorMessage());
        this.apiError = apiError;
    }

    public static Supplier<BaseException> of(ApiError apiError) {
        return () -> new BusinessException(apiError);
    }

}
