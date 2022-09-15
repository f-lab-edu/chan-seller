package com.chan.seller.chanseller.exception;

public class OrderRequestFailedException extends RuntimeException{
    public OrderRequestFailedException() {
    }

    public OrderRequestFailedException(String message) {
        super(message);
    }

    public OrderRequestFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
