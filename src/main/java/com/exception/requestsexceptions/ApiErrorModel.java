package com.exception.requestsexceptions;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ApiErrorModel
{
    String message;
    List<String> details;
    HttpStatus status;
    LocalDateTime timestamp;
}
