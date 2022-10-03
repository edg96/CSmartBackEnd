package com.csmart.mapper;

import com.csmart.mapper.dto.ContractDto;
import com.csmart.model.Contract;
import com.exception.mapper.DtoToEntityFailedTransformationException;
import com.exception.mapper.EntityToDtoFailedTransformationException;

public class ContractMapper
{
    private static ContractMapper contractMapper = null;

    private ContractMapper(){}

    public static ContractMapper getInstance()
    {
        if (contractMapper == null)
            contractMapper = new ContractMapper();

        return contractMapper;
    }

    public ContractDto entityToDto(Contract contract) throws EntityToDtoFailedTransformationException
    {
        return ContractDto.builder()
                .contractIdDto(contract.getContractId())
                .contractTypeDto(contract.getContractType())
                .workHoursPerDayDto(contract.getWorkHoursPerDay())
                .legalDaysOffDto(contract.getLegalDaysOff())
                .brutSalaryDto(contract.getBrutSalary())
                .build();
    }

    public Contract dtoToEntity(ContractDto contractDto) throws DtoToEntityFailedTransformationException
    {
        return Contract.builder()
                .contractId(contractDto.getContractIdDto())
                .contractType(contractDto.getContractTypeDto())
                .workHoursPerDay(contractDto.getWorkHoursPerDayDto())
                .legalDaysOff(contractDto.getLegalDaysOffDto())
                .brutSalary(contractDto.getBrutSalaryDto())
                .build();
    }

}
