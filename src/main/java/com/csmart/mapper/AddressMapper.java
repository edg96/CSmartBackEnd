package com.csmart.mapper;

import com.csmart.dto.AddressDto;
import com.csmart.model.Address;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressMapper
{
    AddressDto modelToDto(Address address);
    List<AddressDto> modelToDtos(List<Address> addressList);
    Address dtoToModel(AddressDto addressDto);
}
