package com.csmart.service.raw;

import com.csmart.model.InvoiceOut;
import com.csmart.repository.InvoiceOutRepository;
import com.exception.general.TargetNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class InvoiceOutService
{
    private final InvoiceOutRepository invoiceOutRepository;

    public List<InvoiceOut> findAll()
    {
        List<InvoiceOut> invoiceOutList = invoiceOutRepository.findAll();
        if(invoiceOutList.isEmpty())
            throw new TargetNotFoundException("The list of invoices out is empty.");

        return new ArrayList<>(invoiceOutList);
    }

    public InvoiceOut findById(UUID invoiceOutId) throws TargetNotFoundException
    {
        Optional<InvoiceOut> invoiceOutOptional = invoiceOutRepository.findById(invoiceOutId);
        if(invoiceOutOptional.isEmpty())
            throw new TargetNotFoundException("No invoice out with the specified ID was found in the database.");

        return invoiceOutOptional.get();
    }

    public InvoiceOut save(InvoiceOut invoiceOut)
    {
        return invoiceOutRepository.save(invoiceOut);
    }

    public InvoiceOut update(UUID invoiceOutId, InvoiceOut invoiceOut)
    {
        InvoiceOut extractedInvoiceOut = invoiceOutRepository.getById(invoiceOutId);
        extractedInvoiceOut = invoiceOut;
        return invoiceOutRepository.save(extractedInvoiceOut);
    }

    public void deleteAll() throws TargetNotFoundException { invoiceOutRepository.deleteAll(); }

    public void deleteSingle(InvoiceOut invoiceOut) throws TargetNotFoundException { invoiceOutRepository.deleteById(invoiceOut.getInvoiceOutId()); }

    public void deleteById(UUID id) throws TargetNotFoundException { invoiceOutRepository.deleteById(id); }
}
