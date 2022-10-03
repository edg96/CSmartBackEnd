package com.csmart.controller;

import com.csmart.model.InvoiceIn;
import com.csmart.service.raw.InvoiceInService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("invoicein")
@RequiredArgsConstructor
public class InvoiceInController
{
    private final InvoiceInService invoiceInService;

    @GetMapping("find/all")
    public ResponseEntity<List<InvoiceIn>> findAll()
    {
        List<InvoiceIn> listOfInvoiceIns = invoiceInService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listOfInvoiceIns);
    }

    @GetMapping("findbyid/{invoiceInId}")
    public ResponseEntity<InvoiceIn> findById(@PathVariable("invoiceInId") UUID invoiceInId)
    {
        InvoiceIn returnedInvoiceIn = invoiceInService.findById(invoiceInId);
        return ResponseEntity.status(HttpStatus.OK).body(returnedInvoiceIn);
    }

    @PostMapping("save")
    public ResponseEntity<InvoiceIn> save(@RequestBody @Valid InvoiceIn invoiceIn)
    {
        InvoiceIn returnedInvoiceIn = invoiceInService.save(invoiceIn);
        return ResponseEntity.status(HttpStatus.OK).body(returnedInvoiceIn);
    }

    @PutMapping("update/{invoiceInId}")
    public ResponseEntity<InvoiceIn> update(@PathVariable("invoiceInId") UUID invoiceInId, @RequestBody @Valid InvoiceIn invoiceIn)
    {
        InvoiceIn returnedInvoiceIn = invoiceInService.update(invoiceInId, invoiceIn);
        return ResponseEntity.status(HttpStatus.OK).body(returnedInvoiceIn);
    }

    @DeleteMapping("delete/all")
    public void deleteAll() { invoiceInService.deleteAll(); }

    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable("id") UUID id) { invoiceInService.deleteById(id); }

    @DeleteMapping("delete/single")
    public void deleteSingle(@RequestBody @Valid InvoiceIn invoiceIn) { invoiceInService.deleteSingle(invoiceIn); }
}
