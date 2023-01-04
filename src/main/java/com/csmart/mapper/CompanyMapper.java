package com.csmart.mapper;

import com.csmart.dto.CompanyDto;
import com.csmart.model.Company;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyMapper
{
    CompanyDto modelToDto(Company company);
    List<CompanyDto> modelToDtos(List<Company> companyList);
    Company dtoToModel(CompanyDto companyDto);
}