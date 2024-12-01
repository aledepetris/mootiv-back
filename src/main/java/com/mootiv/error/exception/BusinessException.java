package com.mootiv.error.exception;

import com.mootiv.error.ApiError;

public class BusinessException extends BaseException {

    public BusinessException(ApiError apiError) {
        super(apiError);
    }

}
