package com.example.memoapi.exception.hendler;

import com.example.memoapi.exception.NoteNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(NoteNotFoundException.class)
    public ResponseEntity<String> handlerNotFoundException(NoteNotFoundException e){
        // return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        return ResponseEntity.notFound().build();
    }
}
