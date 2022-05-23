package com.exception.general;

public class TargetAlreadyExistsException extends RuntimeException
{
    public TargetAlreadyExistsException() { }

    public TargetAlreadyExistsException(String message) { super(message); }
}
