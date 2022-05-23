package com.csmartbackend.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Builder
@Getter
@Setter
public class WorkingPointDto
{
    private UUID workingPointIdDto;
    private String fiscalCodeDto;
    public AddressDto addressDto;
    public Set<EmployeeDto> employeesDto;
}
