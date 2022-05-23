package com.csmartbackend.repository;

import com.csmartbackend.model.InvoiceOut;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InvoiceOutRepository extends JpaRepository<InvoiceOut, UUID>
{

}
