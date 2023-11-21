package com.example.twitterclone.exception;

import com.example.twitterclone.global.error.exception.ErrorCode;
import com.example.twitterclone.global.error.exception.GeneralException;

public class ExampleHandler extends GeneralException {

    public ExampleHandler(ErrorCode errorCode) { // ErrorCode를 받아서 GeneralException의 생성자를 호출
        super(errorCode);
    }
}
