package com.mootiv.error.exception;


import com.mootiv.error.ApiError;

public class NotFoundException extends BaseException {

    public NotFoundException(ApiError apiError) {
        super(apiError);
    }

}
