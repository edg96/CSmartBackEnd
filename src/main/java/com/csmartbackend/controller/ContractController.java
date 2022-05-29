package com.csmartbackend.controller;

import com.csmartbackend.model.Contract;
import com.csmartbackend.service.raw.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("contract")
@RequiredArgsConstructor
public class ContractController
{
    private final ContractService contractService;

    @GetMapping("find/all")
    public ResponseEntity<List<Contract>> findAll()
    {
        List<Contract> listOfContracts = contractService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listOfContracts);
    }

    @GetMapping("findbyid/{contractId}")
    public ResponseEntity<Contract> findById(@PathVariable("contractId") UUID contractId)
    {
        Contract returnedContract = contractService.findById(contractId);
        return ResponseEntity.status(HttpStatus.OK).body(returnedContract);
    }

    @PostMapping("save")
    public ResponseEntity<Contract> save(@RequestBody @Valid Contract contract)
    {
        Contract returnedContract = contractService.save(contract);
        return ResponseEntity.status(HttpStatus.OK).body(returnedContract);
    }

    @PutMapping("update/{contractId}")
    public ResponseEntity<Contract> update(@PathVariable("contractId") UUID contractId, @RequestBody @Valid Contract contract)
    {
        Contract returnedContract = contractService.update(contractId, contract);
        return ResponseEntity.status(HttpStatus.OK).body(returnedContract);
    }

    @DeleteMapping("delete/all")
    public void deleteAll() { contractService.deleteAll(); }

    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable("id") UUID id) { contractService.deleteById(id); }

    @DeleteMapping("delete/single")
    public void deleteSingle(@RequestBody @Valid Contract contract) { contractService.deleteSingle(contract); }
}
