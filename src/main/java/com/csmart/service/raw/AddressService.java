package com.csmart.service.raw;

import com.csmart.model.Address;
import com.csmart.repository.AddressRepository;
import com.exception.general.TargetNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class AddressService
{
    private final AddressRepository addressRepository;

    public List<Address> findAll()
    {
        List<Address> addressList = addressRepository.findAll();
        if(addressList.isEmpty())
            throw new TargetNotFoundException("The list of addresses is empty.");

        return new ArrayList<>(addressList);
    }

    public Address findById(UUID addressId) throws TargetNotFoundException
    {
        Optional<Address> addressOptional = addressRepository.findById(addressId);
        if(addressOptional.isEmpty())
            throw new TargetNotFoundException("No address with the specified ID was found in the database.");

        return addressOptional.get();
    }

    public Address save(Address address)
    {
        return addressRepository.save(address);
    }

    public Address update(UUID addressId, Address address)
    {
        Address extractedAddress = addressRepository.getById(addressId);
        extractedAddress = address;
        return addressRepository.save(extractedAddress);
    }

    public void deleteAll() throws TargetNotFoundException { addressRepository.deleteAll(); }

    public void deleteSingle(Address address) throws TargetNotFoundException { addressRepository.deleteById(address.getAddressId()); }

    public void deleteById(UUID id) throws TargetNotFoundException { addressRepository.deleteById(id); }
}
