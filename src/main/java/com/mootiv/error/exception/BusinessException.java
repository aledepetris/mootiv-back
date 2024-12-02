package com.mootiv.error.exception;

import com.mootiv.error.ApiError;

import java.util.function.Supplier;

public class BusinessException extends BaseException {

    public BusinessException(ApiError apiError) {
        super(apiError);
    }

    public static Supplier<BusinessException> of(ApiError apiError) {
        return () -> new BusinessException(apiError);
    }
}
