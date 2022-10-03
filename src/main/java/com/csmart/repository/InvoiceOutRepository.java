package com.csmart.repository;

import com.csmart.model.InvoiceOut;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InvoiceOutRepository extends JpaRepository<InvoiceOut, UUID>
{

}
