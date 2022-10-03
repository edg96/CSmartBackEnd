package com.csmart.controller;

import com.csmart.service.raw.CompanyService;
import com.csmart.model.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("company")
@RequiredArgsConstructor
public class CompanyController
{
    private final CompanyService companyService;

    @GetMapping("find/all")
    public ResponseEntity<List<Company>> findAll()
    {
        List<Company> listOfCompanies = companyService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listOfCompanies);
    }

    @PostMapping("save")
    public ResponseEntity<Company> update(@RequestBody @Valid Company company)
    {
        Company returnedCompany = companyService.save(company);
        return ResponseEntity.status(HttpStatus.OK).body(returnedCompany);
    }

    @DeleteMapping("delete/all")
    public void deleteAll() { companyService.deleteAll(); }

    @DeleteMapping("delete/single")
    public void deleteSingle(@RequestBody @Valid Company company) { companyService.deleteSingle(company); }

    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable("id") UUID id) { companyService.deleteById(id); }
}
