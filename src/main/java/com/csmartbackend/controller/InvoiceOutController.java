package com.csmartbackend.controller;

import com.csmartbackend.service.raw.InvoiceOutService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("invoiceOut")
@RequiredArgsConstructor
public class InvoiceOutController
{
    private final InvoiceOutService invoiceOutService;

//    @GetMapping("all")
//    public List<InvoiceOutDto> findAll() { return invoiceOutService.findAll(); }
//
//    @PatchMapping("update")
//    public InvoiceOutDto updateEmployee(@RequestBody InvoiceOut invoiceOut) { return invoiceOutService.save(invoiceOut); }
//
//    @PostMapping("save")
//    public InvoiceOutDto saveEmployee(@RequestBody @Valid InvoiceOut invoiceOut) { return invoiceOutService.save(invoiceOut); }
//
//    @DeleteMapping("delete/all")
//    public void deleteAll() { invoiceOutService.deleteAll(); }
//
//    @DeleteMapping("delete/single")
//    public void deleteSingleEmployee(@RequestBody @Valid InvoiceOut invoiceOut) { invoiceOutService.deleteSingle(invoiceOut); }
//
//    @DeleteMapping("delete/{id}")
//    public void deleteEmployeeById(@PathVariable("id") UUID id) { invoiceOutService.deleteById(id); }
}
