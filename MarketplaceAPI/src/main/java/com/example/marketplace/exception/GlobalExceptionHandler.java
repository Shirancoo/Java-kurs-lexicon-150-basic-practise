package com.example.marketplace.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

// Här hanterar vi olika fel
@RestControllerAdvice
public class GlobalExceptionHandler {

    // Valideringsfel som @NotBlank och sånt
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> valideringsFel(MethodArgumentNotValidException ex) {
        Map<String, String> felMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                felMap.put(error.getField(), error.getDefaultMessage())
        );
        return new ResponseEntity<>(felMap, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<String> hanteraRedanRegistrerad(UserAlreadyExistsException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<String> hanteraFelLogin(InvalidCredentialsException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(AdvertisementExpiredException.class)
    public ResponseEntity<String> hanteraGammalAnnons(AdvertisementExpiredException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.GONE);
    }

    // Om nåt annat helt oväntat händer?
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> hanteraAllmäntFel(Exception ex) {
        System.out.println("FEL: " + ex); // debug, ta bort i produktion
        return new ResponseEntity<>("Något gick fel: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
