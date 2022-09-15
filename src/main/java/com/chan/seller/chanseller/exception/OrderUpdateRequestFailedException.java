package com.chan.seller.chanseller.exception;

public class OrderUpdateRequestFailedException extends RuntimeException{
    public OrderUpdateRequestFailedException() {
    }

    public OrderUpdateRequestFailedException(String message) {
        super(message);
    }

    public OrderUpdateRequestFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
