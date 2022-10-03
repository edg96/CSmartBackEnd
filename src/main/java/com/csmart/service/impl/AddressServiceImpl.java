package com.csmart.service.impl;

import com.csmart.model.Address;

import java.util.List;

public interface AddressServiceImpl
{
    List<Address> getAllAddresses();
    Address getAddressById();
}
