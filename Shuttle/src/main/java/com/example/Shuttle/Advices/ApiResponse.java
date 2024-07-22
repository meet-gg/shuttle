package com.example.Shuttle.Advices;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ApiResponse<T> {
    @JsonFormat(pattern = "hh-mm-ss dd-MM-yyyy")
    private LocalDateTime localDateTime;
    private T data;
    private ApiError apiError;

    public ApiResponse() {
        this.localDateTime =LocalDateTime.now();
    }
    public ApiResponse(T data) {
        this();
        this.data = data;
    }
    public ApiResponse(ApiError apiError) {
        this();
        this.apiError = apiError;
    }


}
