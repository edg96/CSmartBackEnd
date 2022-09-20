package com.csmartbackend.mapper;

import com.csmartbackend.mapper.dto.EmployeeDto;
import com.csmartbackend.model.Employee;
import com.exception.mapper.DtoToEntityFailedTransformationException;
import com.exception.mapper.EntityToDtoFailedTransformationException;

public class EmployeeMapper
{
    private static EmployeeMapper employeeMapper = null;

    private EmployeeMapper(){}

    public static EmployeeMapper getInstance()
    {
        if (employeeMapper == null)
            employeeMapper = new EmployeeMapper();

        return employeeMapper;
    }

    public EmployeeDto entityToDto(Employee employee) throws EntityToDtoFailedTransformationException
    {
        return EmployeeDto.builder()
                .employeeIdDto(employee.getEmployeeId())
                .cnpDto(employee.getCnp())
                .firstNameDto(employee.getFirstName())
                .lastNameDto(employee.getLastName())
                .studiesDto(employee.getStudies())
                .roleDto(employee.getRole())
                .employeeIdDto(employee.getEmployeeId())
                .addressDto(AddressMapper.getInstance().entityToDto(employee.getAddress()))
                .contractDto(ContractMapper.getInstance().entityToDto(employee.getContract()))
                .build();
    }

    public Employee dtoToEntity(EmployeeDto employeeDto) throws DtoToEntityFailedTransformationException
    {
        return Employee.builder()
                .employeeId(employeeDto.getEmployeeIdDto())
                .cnp(employeeDto.getCnpDto())
                .firstName(employeeDto.getFirstNameDto())
                .lastName(employeeDto.getLastNameDto())
                .studies(employeeDto.getStudiesDto())
                .role(employeeDto.getRoleDto())
                .employmentDate(employeeDto.getEmploymentDateDto())
                .address(AddressMapper.getInstance().dtoToEntity(employeeDto.getAddressDto()))
                .contract(ContractMapper.getInstance().dtoToEntity(employeeDto.getContractDto()))
                .build();
    }
}