package com.example.Shuttle.Advices;

import com.example.Shuttle.Exception.ResourceNotFoundException;
import org.aspectj.lang.annotation.AdviceName;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<?>> handleResourcenotfound(ResourceNotFoundException exception){
        ApiError apiError= ApiError.builder()
                .httpStatus(HttpStatus.NOT_FOUND)
                .message(exception.getMessage())
                .build();
        return ErrorResponseEntity(apiError);
    }

    private ResponseEntity<ApiResponse<?>> ErrorResponseEntity(ApiError apiError) {
            return new ResponseEntity<>(new ApiResponse<>(apiError),apiError.getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleServerexception(Exception exception){
        ApiError apiError= ApiError.builder()
                .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .message(exception.getMessage())
                .build();
        return ErrorResponseEntity(apiError);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>> handleInputvalidationerror(MethodArgumentNotValidException exception){
        List<String> errors=exception
                .getBindingResult()
                .getAllErrors()
                .stream()
                .map(objectError -> objectError.getDefaultMessage())
                .collect(Collectors.toList());
        ApiError apiError= ApiError.builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .message("input validation Error")
                .otherError(errors)
                .build();
        return ErrorResponseEntity(apiError);
    }



}
