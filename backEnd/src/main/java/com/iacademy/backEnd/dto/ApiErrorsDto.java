package com.iacademy.backEnd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ApiErrorsDto {

    String message;
    String details;
    HttpStatus httpStatus;
    LocalDateTime timestamp;



}
