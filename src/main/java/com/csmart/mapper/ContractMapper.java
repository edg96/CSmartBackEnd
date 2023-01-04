package com.csmart.mapper;

import com.csmart.dto.ContractDto;
import com.csmart.model.Contract;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContractMapper
{
    ContractDto modelToDto(Contract contract);
    List<ContractDto> modelToDtos(List<Contract> contractList);
    Contract dtoToModel(ContractDto contractDto);
}