package com.mootiv.error.exception;


import com.mootiv.error.ApiError;

import java.util.function.Supplier;

public class NotFoundException extends BaseException {

    public NotFoundException(ApiError apiError) {
        super(apiError);
    }

    public static Supplier<NotFoundException> of(ApiError apiError) {
        return () -> new NotFoundException(apiError);
    }

}
