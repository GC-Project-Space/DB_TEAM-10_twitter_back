package com.example.twitterclone.exception;

import com.example.twitterclone.global.error.exception.ErrorCode;
import com.example.twitterclone.global.error.exception.GeneralException;

public class ExampleHandler extends GeneralException {

    public ExampleHandler(ErrorCode errorCode) {
        super(errorCode);
    }
}
