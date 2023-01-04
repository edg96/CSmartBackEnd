package com.csmart.mapper;

import com.csmart.dto.WorkingPointDto;
import com.csmart.model.WorkingPoint;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WorkingPointMapper
{
    WorkingPointDto modelToDto(WorkingPoint WorkingPoint);
    List<WorkingPointDto> modelToDtos(List<WorkingPoint> WorkingPointList);
    WorkingPoint dtoToModel(WorkingPointDto WorkingPointDto);
}