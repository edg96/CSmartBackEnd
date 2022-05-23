package com.exception.general;

public class TargetNotFoundException extends RuntimeException
{
    public TargetNotFoundException() { }

    public TargetNotFoundException(String message) { super(message); }
}
