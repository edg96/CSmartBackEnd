package com.csmartbackend.dto;

import com.csmartbackend.model.InvoiceIn.UnitOfMeasureType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Builder
@Setter
@Getter
public class InvoiceInDto
{
    private UUID invoiceInIdDto;
    private String codeDto;
    private String dateDto;
    private int articleNumberDto;
    private String productNameDto;
    private UnitOfMeasureType unitOfMeasureDto;
    private int quantityDto;
    private double unitaryPriceDto;
    private double valueWithoutTvaDto;
    private double valueWithTvaDto;
}
