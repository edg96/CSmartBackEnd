package com.csmartbackend.controller;

import com.csmartbackend.dto.CompanyDto;
import com.csmartbackend.service.raw.CompanyService;
import com.csmartbackend.model.Company;
import lombok.RequiredArgsConstructor;
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
    public List<CompanyDto> findAll() { return companyService.findAll(); }

    @PostMapping("save")
    public CompanyDto update(@RequestBody @Valid Company company) { return companyService.save(company); }

    @DeleteMapping("delete/all")
    public void deleteAll() { companyService.deleteAll(); }

    @DeleteMapping("delete/single")
    public void deleteSingle(@RequestBody @Valid Company company) { companyService.deleteSingle(company); }

    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable("id") UUID id) { companyService.deleteById(id); }
}
