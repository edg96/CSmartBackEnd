package com.csmartbackend.mapper;

import com.csmartbackend.dto.ProviderDto;
import com.csmartbackend.model.Provider;
import com.exception.mapper.DtoToEntityFailedTransformationException;
import com.exception.mapper.EntityToDtoFailedTransformationException;

public class ProviderMapper
{
    private static ProviderMapper providerMapper = null;

    private ProviderMapper(){}

    public static ProviderMapper getInstance()
    {
        if (providerMapper == null)
            providerMapper = new ProviderMapper();

        return providerMapper;
    }

    public ProviderDto entityToDto(Provider provider) throws EntityToDtoFailedTransformationException
    {
        return ProviderDto.builder()
                .providerIdDto(provider.getProviderId())
                .fiscalCodeDto(provider.getFiscalCode())
                .addressDto(AddressMapper.getInstance().entityToDto(provider.getAddress()))
                .build();
    }

    public Provider dtoToEntity(ProviderDto providerDto) throws DtoToEntityFailedTransformationException
    {
        return Provider.builder()
                .providerId(providerDto.getProviderIdDto())
                .fiscalCode(providerDto.getFiscalCodeDto())
                .address(AddressMapper.getInstance().dtoToEntity(providerDto.getAddressDto()))
                .build();
    }
}
