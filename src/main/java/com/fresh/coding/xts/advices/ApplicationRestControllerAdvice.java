package com.fresh.coding.xts.advices;

import com.fresh.coding.xts.exceptions.BadRequestException;
import com.fresh.coding.xts.exceptions.InternalServerException;
import com.fresh.coding.xts.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationRestControllerAdvice {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ApplicationError<String> handleNotFoundException(NotFoundException ex) {
     return new ApplicationError<>(
                ex.getMessage(),
                LocalDate.now(),
                HttpStatus.NOT_FOUND.value()
        );
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ApplicationError<String> handleBadRequestException(BadRequestException ex) {
        return new ApplicationError<>(
                ex.getMessage(),
                LocalDate.now(),
                HttpStatus.BAD_REQUEST.value()
        );
    }

    @ExceptionHandler(InternalServerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ApplicationError<String> handleInternalServerException(InternalServerException ex) {
        return new ApplicationError<>(
                ex.getMessage(),
                LocalDate.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value()
        );
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ApplicationError<String> handleGeneralException(Exception ex) {
        return new ApplicationError<>(
                ex.getMessage(),
                LocalDate.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value()
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApplicationError<Map<String, String>> handleError(MethodArgumentNotValidException ex) {
        var errors = new HashMap<String, String>();
        ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        return new ApplicationError<>(
                errors,
                LocalDate.now(),
                HttpStatus.BAD_REQUEST.value()
        );
    }
}
