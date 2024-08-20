package com.javacod.wallettesttask.exception.controller;

import com.javacod.wallettesttask.exception.InsufficientFundsException;
import com.javacod.wallettesttask.exception.WalletNotFoundException;
import org.modelmapper.spi.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerHandlerException {
    @ExceptionHandler(WalletNotFoundException.class)
    public ResponseEntity<ErrorMessage> walletNotFoundException(WalletNotFoundException e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorMessage(e.getMessage()));
    }
    @ExceptionHandler(InsufficientFundsException.class)
    public ResponseEntity<ErrorMessage> innsufficientFundsException(InsufficientFundsException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorMessage(e.getMessage()));
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorMessage> httpMessageNotReadableException() {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorMessage("Not valid JSON"));
    }
}
