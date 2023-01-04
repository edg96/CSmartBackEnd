package com.csmart.mapper;

import com.csmart.dto.ProviderDto;
import com.csmart.model.Provider;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProviderMapper
{
    ProviderDto modelToDto(Provider Provider);
    List<ProviderDto> modelToDtos(List<Provider> ProviderList);
    Provider dtoToModel(ProviderDto ProviderDto);
}