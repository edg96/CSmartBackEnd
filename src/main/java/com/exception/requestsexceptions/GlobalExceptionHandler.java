package com.exception.requestsexceptions;

import com.exception.general.CNPNotFoundException;
import com.exception.general.TargetAlreadyExistsException;
import com.exception.general.TargetNotFoundException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler
{
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported
            (HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request)
    {
        String message = ex.getMessage();
        List<String> details = new ArrayList<>();
        details.add("Request method not supported.");
        ApiErrorModel apiErrorModel = new ApiErrorModel(message, details, status, LocalDateTime.now());
        return ResponseEntity.status(status).body(apiErrorModel);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported
            (HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request)
    {
        String message = ex.getMessage();
        List<String> details = new ArrayList<>();
        details.add("Media method not supported.");
        ApiErrorModel apiErrorModel = new ApiErrorModel(message, details, status, LocalDateTime.now());
        return ResponseEntity.status(status).body(apiErrorModel);
    }

    @Override
    protected ResponseEntity<Object> handleMissingPathVariable
            (MissingPathVariableException ex, HttpHeaders headers, HttpStatus status, WebRequest request)
    {
        String message = ex.getMessage();
        List<String> details = new ArrayList<>();
        details.add("Path variable is missing.");
        ApiErrorModel apiErrorModel = new ApiErrorModel(message, details, status, LocalDateTime.now());
        return ResponseEntity.status(status).body(apiErrorModel);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter
            (MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request)
    {
        String message = ex.getMessage();
        List<String> details = new ArrayList<>();
        details.add("Request parameter is missing.");
        ApiErrorModel apiErrorModel = new ApiErrorModel(message, details, status, LocalDateTime.now());
        return ResponseEntity.status(status).body(apiErrorModel);
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch
            (TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request)
    {
        String message = ex.getMessage();
        List<String> details = new ArrayList<>();
        details.add("Mismatch of type.");
        ApiErrorModel apiErrorModel = new ApiErrorModel(message, details, status, LocalDateTime.now());
        return ResponseEntity.status(status).body(apiErrorModel);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable
            (HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request)
    {
        String message = ex.getMessage();
        List<String> details = new ArrayList<>();
        details.add("Request body is not readable.");
        ApiErrorModel apiErrorModel = new ApiErrorModel(message, details, status, LocalDateTime.now());
        return ResponseEntity.status(status).body(apiErrorModel);
    }

    @ExceptionHandler(TargetNotFoundException.class)
    public ResponseEntity<Object> handleTargetNotFound(TargetNotFoundException ex)
    {
        String message = ex.getMessage();
        List<String> details = new ArrayList<>();
        details.add("Can't find any records in the database.");
        ApiErrorModel apiErrorModel = new ApiErrorModel(message, details, HttpStatus.NOT_FOUND, LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiErrorModel);
    }

    @ExceptionHandler(TargetAlreadyExistsException.class)
    public ResponseEntity<Object> handleTargetAlreadyExists(TargetAlreadyExistsException ex)
    {
        String message = ex.getMessage();
        List<String> details = new ArrayList<>();
        details.add("Object given is already present in the database.");
        ApiErrorModel apiErrorModel = new ApiErrorModel(message, details, HttpStatus.NOT_FOUND, LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiErrorModel);
    }

    @ExceptionHandler(CNPNotFoundException.class)
    public ResponseEntity<Object> handleInvalidCNPException(CNPNotFoundException ex)
    {
        String message = ex.getMessage();
        List<String> details = new ArrayList<>();
        details.add("Try to check the CNP again to make sure that you typed it correctly. " +
                "If the error persist in means that there is not an employee with the specified CNP in the database.");
        ApiErrorModel apiErrorModel = new ApiErrorModel(message, details, HttpStatus.NOT_FOUND, LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiErrorModel);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleOtherExceptions(Exception ex)
    {
        String message = ex.getMessage();
        List<String> details = new ArrayList<>();
        details.add("Other error occurred.");
        ApiErrorModel apiErrorModel = new ApiErrorModel(message, details, HttpStatus.BAD_REQUEST, LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiErrorModel);
    }
}
