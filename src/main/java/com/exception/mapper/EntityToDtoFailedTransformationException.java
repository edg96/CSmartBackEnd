package com.exception.mapper;

public class EntityToDtoFailedTransformationException extends RuntimeException
{
    public EntityToDtoFailedTransformationException() { super("Failed to transform Entity to Dto."); }
}
