package ru.alexrov.order.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashSet;
import java.util.Set;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<IncorrectData> handleException(NotFoundException exception) {
        IncorrectData incorrectData = new IncorrectData();
        incorrectData.setMessage(exception.getMessage());
        incorrectData.setHttpStatus(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(incorrectData, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<IncorrectData> handleAllException(Exception exception) {
        IncorrectData incorrectData = new IncorrectData();
        incorrectData.setMessage("Произошла ошибка");
        incorrectData.setErrorText(exception.getMessage());
        return new ResponseEntity<>(incorrectData, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler
    public ResponseEntity<IncorrectData> handleAllException(RuntimeException exception) {
        IncorrectData incorrectData = new IncorrectData();
        incorrectData.setMessage("Произошла ошибка");
        incorrectData.setErrorText(exception.getMessage());
        return new ResponseEntity<>(incorrectData, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<IncorrectData> handleAllException(MethodArgumentNotValidException exception) {
        IncorrectData incorrectData = new IncorrectData();
        Set<String> errors = new HashSet<>();
        exception.getBindingResult().getAllErrors()
                .forEach(error -> {
                    var errorMessage = error.getDefaultMessage();
                    errors.add(errorMessage);
                });
        incorrectData.setMessage("Произошла ошибка");
        incorrectData.setValidationErrors(errors);
        return new ResponseEntity<>(incorrectData, HttpStatus.BAD_REQUEST);
    }
}
