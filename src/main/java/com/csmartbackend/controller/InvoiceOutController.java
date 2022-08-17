package com.csmartbackend.controller;

import com.csmartbackend.model.InvoiceOut;
import com.csmartbackend.service.raw.InvoiceOutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("invoiceout")
@RequiredArgsConstructor
public class InvoiceOutController
{
    private final InvoiceOutService invoiceOutService;

    @GetMapping("find/all")
    public ResponseEntity<List<InvoiceOut>> findAll()
    {
        List<InvoiceOut> listOfInvoiceOuts = invoiceOutService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listOfInvoiceOuts);
    }

    @GetMapping("findbyid/{invoiceOutId}")
    public ResponseEntity<InvoiceOut> findById(@PathVariable("invoiceOutId") UUID invoiceOutId)
    {
        InvoiceOut returnedInvoiceOut = invoiceOutService.findById(invoiceOutId);
        return ResponseEntity.status(HttpStatus.OK).body(returnedInvoiceOut);
    }

    @PostMapping("save")
    public ResponseEntity<InvoiceOut> save(@RequestBody @Valid InvoiceOut invoiceOut)
    {
        InvoiceOut returnedInvoiceOut = invoiceOutService.save(invoiceOut);
        return ResponseEntity.status(HttpStatus.OK).body(returnedInvoiceOut);
    }

    @PutMapping("update/{invoiceOutId}")
    public ResponseEntity<InvoiceOut> update(@PathVariable("invoiceOutId") UUID invoiceOutId, @RequestBody @Valid InvoiceOut invoiceOut)
    {
        InvoiceOut returnedInvoiceOut = invoiceOutService.update(invoiceOutId, invoiceOut);
        return ResponseEntity.status(HttpStatus.OK).body(returnedInvoiceOut);
    }

    @DeleteMapping("delete/all")
    public void deleteAll() { invoiceOutService.deleteAll(); }

    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable("id") UUID id) { invoiceOutService.deleteById(id); }

    @DeleteMapping("delete/single")
    public void deleteSingle(@RequestBody @Valid InvoiceOut invoiceOut) { invoiceOutService.deleteSingle(invoiceOut); }
}
