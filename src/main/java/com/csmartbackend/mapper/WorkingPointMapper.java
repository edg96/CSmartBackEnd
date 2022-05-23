package com.csmartbackend.mapper;

import com.csmartbackend.dto.WorkingPointDto;
import com.csmartbackend.model.WorkingPoint;
import com.exception.mapper.DtoToEntityFailedTransformationException;
import com.exception.mapper.EntityToDtoFailedTransformationException;

import java.util.stream.Collectors;

public class WorkingPointMapper
{
    private static WorkingPointMapper workingPointMapper = null;

    private WorkingPointMapper(){}

    public static WorkingPointMapper getInstance()
    {
        if (workingPointMapper == null)
            workingPointMapper = new WorkingPointMapper();

        return workingPointMapper;
    }

    public WorkingPointDto entityToDto(WorkingPoint workingPoint) throws EntityToDtoFailedTransformationException
    {
        return WorkingPointDto.builder()
                .workingPointIdDto(workingPoint.getWorkingPointId())
                .fiscalCodeDto(workingPoint.getFiscalCode())
                .addressDto(AddressMapper.getInstance().entityToDto(workingPoint.getAddress()))
                .employeesDto(
                        workingPoint.getEmployees().stream()
                                .map(employee -> EmployeeMapper.getInstance().entityToDto(employee))
                                .collect(Collectors.toSet())
                )
                .build();
    }

    public WorkingPoint dtoToEntity(WorkingPointDto workingPointDto) throws DtoToEntityFailedTransformationException
    {
        return WorkingPoint.builder()
                .workingPointId(workingPointDto.getWorkingPointIdDto())
                .fiscalCode(workingPointDto.getFiscalCodeDto())
                .address(AddressMapper.getInstance().dtoToEntity(workingPointDto.getAddressDto()))
                .employees(
                        workingPointDto.getEmployeesDto().stream()
                                .map(employeeDto -> EmployeeMapper.getInstance().dtoToEntity(employeeDto))
                                .collect(Collectors.toSet())
                )
                .build();
    }
}
