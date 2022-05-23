package com.csmartbackend.controller;

import com.csmartbackend.dto.AddressDto;
import com.csmartbackend.model.Address;
import com.csmartbackend.service.raw.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("address")
@RequiredArgsConstructor
public class AddressController
{
    private final AddressService addressService;

    @GetMapping("find/all")
    public ResponseEntity<List<AddressDto>> findAll()
    {
        List<AddressDto> AddressList = addressService.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(AddressList);
    }

    @PostMapping("save")
    public AddressDto update(@RequestBody @Valid Address address) { return addressService.save(address); }
}
