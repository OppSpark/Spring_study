package com.fastcampus.programming.dmaker.exception;

import lombok.Getter;

/**
 * @author oppspark
 */
@Getter
public class DMakerException extends RuntimeException {
    private DMakerErrorCode dMakerErrorCode;
    private String detailMessage;


    public DMakerException(DMakerErrorCode errorCode) {
        super(errorCode.getMessage());
        this.dMakerErrorCode = errorCode;
        this.detailMessage = errorCode.getMessage();
    }

    //디테일 메시지와 에러코드가 같이 담겨 있을 때
    public DMakerException(DMakerErrorCode errorCode, String detailMessage) {
        super(detailMessage);
        this.dMakerErrorCode = errorCode;
        this.detailMessage = errorCode.getMessage();
    }
}
