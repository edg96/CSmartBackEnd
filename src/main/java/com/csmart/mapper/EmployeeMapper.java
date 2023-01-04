package com.csmart.mapper;

import com.csmart.dto.EmployeeDto;
import com.csmart.model.Employee;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "sprig")
public interface EmployeeMapper
{
    EmployeeDto modelToDto(Employee Employee);
    List<EmployeeDto> modelToDtos(List<Employee> EmployeeList);
    Employee dtoToModel(EmployeeDto EmployeeDto);
}