package com.csmart.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Builder
@Getter
@Setter
public class EmployeeDto
{
    private UUID employeeIdDto;
    private String cnpDto;
    private String firstNameDto;
    private String lastNameDto;
    private String studiesDto;
    private String roleDto;
    private Date employmentDateDto;
    public AddressDto addressDto;
    public ContractDto contractDto;
}
