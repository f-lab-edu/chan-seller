package com.chan.seller.chanseller.handler;

import com.chan.seller.chanseller.common.Message;
import com.chan.seller.chanseller.common.StatusEnum;
import com.chan.seller.chanseller.exception.OrderRequestFailedException;
import com.chan.seller.chanseller.exception.OrderRequestValidationFailedException;
import com.chan.seller.chanseller.exception.OrderUpdateRequestFailedException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SellerExceptionHandler {

    @ExceptionHandler(OrderRequestValidationFailedException.class)
    public ResponseEntity<Message> handleException(OrderRequestValidationFailedException ex){
        return responseBadRequest(ex.getMessage());
    }

    @ExceptionHandler(OrderRequestFailedException.class)
    public ResponseEntity<Message> handleException(OrderRequestFailedException ex){
        return responseBadRequest(ex.getMessage());
    }

    @ExceptionHandler(OrderUpdateRequestFailedException.class)
    public ResponseEntity<Message> handleException(OrderUpdateRequestFailedException ex){
        return responseBadRequest(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Message> handleException(Exception ex){
        return responseInternalServerError(ex.getMessage());
    }

    private ResponseEntity responseBadRequest(String messages) {
        Message message = new Message();
        message.setStatus(StatusEnum.BAD_REQUEST);
        message.setMessage(messages);
        return ResponseEntity.badRequest().body(message);
    }

    private ResponseEntity responseInternalServerError(String messages) {
        Message message = new Message();
        message.setStatus(StatusEnum.BAD_REQUEST);
        message.setMessage(messages);
        return ResponseEntity.internalServerError().body(message);
    }
}
