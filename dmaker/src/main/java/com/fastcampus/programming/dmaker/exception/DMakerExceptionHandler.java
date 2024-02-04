package com.fastcampus.programming.dmaker.exception;

import com.fastcampus.programming.dmaker.dto.DMakerErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class DMakerExceptionHandler {
    @ExceptionHandler(DMakerException.class)
    public DMakerErrorResponse handleException (DMakerException e, HttpServletRequest request){
        log.error("errorCode :{}, url : {}, message : {}", e.getDMakerErrorCode(),request.getRequestURI(), e.getDetailMessage());
        return DMakerErrorResponse.builder()
                .errorCode(e.getDMakerErrorCode())
                .errorMassage(e.getDetailMessage())
                .build();
    }

    @ExceptionHandler(value = {
            HttpRequestMethodNotSupportedException.class,
            MethodArgumentNotValidException.class})
    public DMakerErrorResponse handleBadRequest(Exception e, HttpServletRequest request){
        log.error("url : {}, message : {}", request.getRequestURI(), e.getMessage());
        return DMakerErrorResponse.builder()
                .errorCode(DMakerErrorCode.INVALID_REQUEST)
                .errorMassage(DMakerErrorCode.INVALID_REQUEST.getMessage())
                .build();
    }
    @ExceptionHandler(Exception.class)
    public DMakerErrorResponse handleException(Exception e, HttpServletRequest request){
        return DMakerErrorResponse.builder()
                .errorCode(DMakerErrorCode.INTERNAL_SERVER_ERROR)
                .errorMassage(DMakerErrorCode.INTERNAL_SERVER_ERROR.getMessage())
                .build();
    }
}
