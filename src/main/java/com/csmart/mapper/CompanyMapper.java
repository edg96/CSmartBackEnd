package com.csmart.mapper;

import com.csmart.mapper.dto.CompanyDto;
import com.csmart.model.Company;
import com.exception.mapper.DtoToEntityFailedTransformationException;
import com.exception.mapper.EntityToDtoFailedTransformationException;

import java.util.stream.Collectors;

public class CompanyMapper
{
    private static CompanyMapper companyMapper = null;

    private CompanyMapper(){}

    public static CompanyMapper getInstance()
    {
        if (companyMapper == null)
            companyMapper = new CompanyMapper();

        return companyMapper;
    }

    public CompanyDto entityToDto(Company company) throws EntityToDtoFailedTransformationException
    {
        return CompanyDto.builder()
                .companyIdDto(company.getCompanyId())
                .registerNumberDto(company.getRegisterNumber())
                .fiscalCodeDto(company.getFiscalCode())
                .addressDto(AddressMapper.getInstance().entityToDto(company.getAddress()))
                .workingPointsDto(
                        company.getWorkingPoints().stream()
                                .map(workingPoint -> WorkingPointMapper.getInstance().entityToDto(workingPoint))
                                .collect(Collectors.toSet())
                )
                .build();

    }

    public Company dtoToEntity(CompanyDto companyDto) throws DtoToEntityFailedTransformationException
    {
        return Company.builder()
                .companyId(companyDto.getCompanyIdDto())
                .registerNumber(companyDto.getRegisterNumberDto())
                .fiscalCode(companyDto.getFiscalCodeDto())
                .address(AddressMapper.getInstance().dtoToEntity(companyDto.getAddressDto()))
                .workingPoints(
                        companyDto.getWorkingPointsDto().stream()
                                .map(workingPointDto -> WorkingPointMapper.getInstance().dtoToEntity(workingPointDto))
                                .collect(Collectors.toSet())
                )
                .build();
    }
}