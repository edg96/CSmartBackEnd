package com.csmartbackend.service.impl;

import com.csmartbackend.model.Address;

import java.util.List;

public interface AddressServiceImpl
{
    List<Address> getAllAddresses();
    Address getAddressById();
}
