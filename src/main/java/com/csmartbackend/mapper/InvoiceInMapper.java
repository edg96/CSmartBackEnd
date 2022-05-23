package com.csmartbackend.mapper;

import com.csmartbackend.model.InvoiceIn;
import com.csmartbackend.dto.InvoiceInDto;
import com.exception.mapper.DtoToEntityFailedTransformationException;
import com.exception.mapper.EntityToDtoFailedTransformationException;

public class InvoiceInMapper
{
    private static InvoiceInMapper invoiceInMapper = null;

    private InvoiceInMapper(){}

    public static InvoiceInMapper getInstance()
    {
        if (invoiceInMapper == null)
            invoiceInMapper = new InvoiceInMapper();

        return invoiceInMapper;
    }

    public InvoiceInDto entityToDto(InvoiceIn invoiceIn) throws EntityToDtoFailedTransformationException
    {
        return InvoiceInDto.builder()
                .invoiceInIdDto(invoiceIn.getInvoiceInId())
                .codeDto(invoiceIn.getCode())
                .dateDto(invoiceIn.getDate())
                .articleNumberDto(invoiceIn.getArticleNumber())
                .productNameDto(invoiceIn.getProductName())
                .unitOfMeasureDto(invoiceIn.getUnitOfMeasure())
                .quantityDto(invoiceIn.getQuantity())
                .unitaryPriceDto(invoiceIn.getUnitaryPrice())
                .valueWithoutTvaDto(invoiceIn.getValueWithoutTva())
                .valueWithTvaDto(invoiceIn.getValueWithTva())
                .build();
    }

    public InvoiceIn dtoToEntity(InvoiceInDto invoiceInDto) throws DtoToEntityFailedTransformationException
    {
        return InvoiceIn.builder()
                .invoiceInId(invoiceInDto.getInvoiceInIdDto())
                .code(invoiceInDto.getCodeDto())
                .date(invoiceInDto.getDateDto())
                .articleNumber(invoiceInDto.getArticleNumberDto())
                .productName(invoiceInDto.getProductNameDto())
                .unitOfMeasure(invoiceInDto.getUnitOfMeasureDto())
                .quantity(invoiceInDto.getQuantityDto())
                .unitaryPrice(invoiceInDto.getUnitaryPriceDto())
                .valueWithoutTva(invoiceInDto.getValueWithoutTvaDto())
                .valueWithTva(invoiceInDto.getValueWithTvaDto())
                .build();
    }
}
