package com.csmartbackend.controller;

import com.csmartbackend.model.Address;
import com.csmartbackend.service.raw.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("address")
@RequiredArgsConstructor
public class AddressController
{
    private final AddressService addressService;

    @GetMapping("find/all")
    public ResponseEntity<List<Address>> findAll()
    {
        List<Address> listOfAddresss = addressService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listOfAddresss);
    }

    @GetMapping("findbyid/{addressId}")
    public ResponseEntity<Address> findById(@PathVariable("addressId") UUID addressId)
    {
        Address returnedAddress = addressService.findById(addressId);
        return ResponseEntity.status(HttpStatus.OK).body(returnedAddress);
    }

    @PostMapping("save")
    public ResponseEntity<Address> save(@RequestBody @Valid Address address)
    {
        Address returnedAddress = addressService.save(address);
        return ResponseEntity.status(HttpStatus.OK).body(returnedAddress);
    }

    @PutMapping("update/{addressId}")
    public ResponseEntity<Address> update(@PathVariable("addressId") UUID addressId, @RequestBody @Valid Address address)
    {
        Address returnedAddress = addressService.update(addressId, address);
        return ResponseEntity.status(HttpStatus.OK).body(returnedAddress);
    }

    @DeleteMapping("delete/all")
    public void deleteAll() { addressService.deleteAll(); }

    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable("id") UUID id) { addressService.deleteById(id); }

    @DeleteMapping("delete/single")
    public void deleteSingle(@RequestBody @Valid Address address) { addressService.deleteSingle(address); }
}
