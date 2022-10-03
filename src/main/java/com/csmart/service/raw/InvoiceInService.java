package com.csmart.service.raw;

import com.csmart.model.InvoiceIn;
import com.csmart.repository.InvoiceInRepository;
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
public class InvoiceInService
{
    private final InvoiceInRepository invoiceInRepository;

    public List<InvoiceIn> findAll()
    {
        List<InvoiceIn> invoiceInList = invoiceInRepository.findAll();
        if(invoiceInList.isEmpty())
            throw new TargetNotFoundException("The list of invoices in is empty.");

        return new ArrayList<>(invoiceInList);
    }

    public InvoiceIn findById(UUID invoiceInId) throws TargetNotFoundException
    {
        Optional<InvoiceIn> invoiceInOptional = invoiceInRepository.findById(invoiceInId);
        if(invoiceInOptional.isEmpty())
            throw new TargetNotFoundException("No invoice in with the specified ID was found in the database.");

        return invoiceInOptional.get();
    }

    public InvoiceIn save(InvoiceIn invoiceIn)
    {
        return invoiceInRepository.save(invoiceIn);
    }

    public InvoiceIn update(UUID invoiceInId, InvoiceIn invoiceIn)
    {
        InvoiceIn extractedInvoiceIn = invoiceInRepository.getById(invoiceInId);
        extractedInvoiceIn = invoiceIn;
        return invoiceInRepository.save(extractedInvoiceIn);
    }

    public void deleteAll() throws TargetNotFoundException { invoiceInRepository.deleteAll(); }

    public void deleteSingle(InvoiceIn invoiceIn) throws TargetNotFoundException { invoiceInRepository.deleteById(invoiceIn.getInvoiceInId()); }

    public void deleteById(UUID id) throws TargetNotFoundException { invoiceInRepository.deleteById(id); }
}
