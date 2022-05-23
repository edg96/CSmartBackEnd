package com.csmartbackend.controller;

import com.csmartbackend.model.InvoiceIn;
import com.csmartbackend.service.raw.InvoiceInService;
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
        List<InvoiceIn> invoiceInList = invoiceInService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(invoiceInList);
    }

    @GetMapping("findbyid/{invoiceInId}")
    public ResponseEntity<InvoiceIn> findById(@PathVariable("invoiceInId") UUID invoiceInId)
    {
        InvoiceIn invoiceIn = invoiceInService.findById(invoiceInId);
        return ResponseEntity.status(HttpStatus.OK).body(invoiceIn);
    }

    @PostMapping("save")
    public ResponseEntity<InvoiceIn> save(@RequestBody @Valid InvoiceIn invoiceIn)
    {
        InvoiceIn returnedInvoiceIn = invoiceInService.save(invoiceIn);
        return ResponseEntity.status(HttpStatus.OK).body(returnedInvoiceIn);
    }

    @DeleteMapping("delete/all")
    public void deleteAll() { invoiceInService.deleteAll(); }

    @DeleteMapping("delete/{invoiceInId}")
    public void deleteInvoiceInById(@PathVariable("invoiceInId") UUID invoiceInId) { invoiceInService.deleteById(invoiceInId); }
}
