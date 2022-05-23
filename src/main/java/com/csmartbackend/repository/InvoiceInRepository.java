package com.csmartbackend.repository;

import com.csmartbackend.model.InvoiceIn;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InvoiceInRepository extends JpaRepository<InvoiceIn, UUID>
{

}
