package com.csmartbackend.mapper;

import com.csmartbackend.mapper.dto.AddressDto;
import com.csmartbackend.model.Address;
import com.exception.mapper.DtoToEntityFailedTransformationException;
import com.exception.mapper.EntityToDtoFailedTransformationException;

public class AddressMapper
{
    private static AddressMapper addressMapper = null;

    private AddressMapper(){}

    public static AddressMapper getInstance()
    {
        if (addressMapper == null)
            addressMapper = new AddressMapper();

        return addressMapper;
    }

    public AddressDto entityToDto(Address address) throws EntityToDtoFailedTransformationException
    {
        return AddressDto.builder()
                .addressIdDto(address.getAddressId())
                .countyDto(address.getCounty())
                .localityDto(address.getLocality())
                .streetDto(address.getStreet())
                .streetNumberDto(address.getStreetNumber())
                .blockNumberDto(address.getBlockNumber())
                .stairNumberDto(address.getStairNumber())
                .floorDto(address.getFloor())
                .apartmentNumberDto(address.getApartmentNumber())
                .build();
    }

    public Address dtoToEntity(AddressDto addressDto) throws DtoToEntityFailedTransformationException
    {
        return Address.builder()
                .addressId(addressDto.getAddressIdDto())
                .county(addressDto.getCountyDto())
                .locality(addressDto.getLocalityDto())
                .street(addressDto.getStreetDto())
                .stairNumber(addressDto.getStairNumberDto())
                .blockNumber(addressDto.getBlockNumberDto())
                .streetNumber(addressDto.getStreetNumberDto())
                .floor(addressDto.getFloorDto())
                .apartmentNumber(addressDto.getApartmentNumberDto())
                .build();
    }
}
