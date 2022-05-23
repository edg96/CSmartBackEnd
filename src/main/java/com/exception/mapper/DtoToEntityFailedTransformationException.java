package com.exception.mapper;

public class DtoToEntityFailedTransformationException extends RuntimeException
{
    public DtoToEntityFailedTransformationException() { super("Failed to transform Dto to Entity."); }
}
