package com.csmartbackend.controller;

import com.csmartbackend.dto.ContractDto;
import com.csmartbackend.service.raw.ContractService;
import com.csmartbackend.model.Contract;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("contract")
@RequiredArgsConstructor
public class ContractController
{
    private final ContractService contractService;

    @GetMapping("find/all")
    public List<ContractDto> findAll() { return contractService.findAll(); }

    @PostMapping("save")
    public ContractDto save(@RequestBody @Valid Contract contract) { return contractService.save(contract); }
}
