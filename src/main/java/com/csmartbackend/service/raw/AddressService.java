package com.csmartbackend.service.raw;


import com.csmartbackend.dto.AddressDto;
import com.csmartbackend.mapper.AddressMapper;
import com.csmartbackend.model.Address;

import com.csmartbackend.repository.AddressRepository;
import com.exception.general.TargetAlreadyExistsException;
import com.exception.general.TargetNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class AddressService
{
    private final AddressRepository addressRepository;

    public List<AddressDto> findAll()
    {
        List<Address> addressList = addressRepository.findAll();
        if(addressList.isEmpty() || addressList == null)
            throw new TargetNotFoundException();

        AddressMapper addressMapper = AddressMapper.getInstance();
        return addressList.stream()
                .map(addressMapper::entityToDto)
                .collect(Collectors.toList());
    }

    public AddressDto save(Address address)
    {
        /// TODO: 27/04/2022 Rezolva problema. Adresa iti vine din employee
        if(addressRepository.existsById(address.getAddressId()))
        {
            throw new TargetAlreadyExistsException("Adress with the id " + address.getAddressId() + " already exist.");
        }

        addressRepository.save(address);

        return AddressMapper.getInstance().entityToDto(address);
    }

    public void deleteById(UUID id)
    {
        if(!addressRepository.existsById(id))
        {
            throw new TargetAlreadyExistsException("Adress with the id " + id + " already exist.");
        }

        addressRepository.deleteById(id);
    }
}
