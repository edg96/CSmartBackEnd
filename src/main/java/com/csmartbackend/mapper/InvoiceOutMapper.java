package com.csmartbackend.mapper;

import com.csmartbackend.dto.InvoiceOutDto;
import com.csmartbackend.model.InvoiceOut;
import com.exception.mapper.DtoToEntityFailedTransformationException;
import com.exception.mapper.EntityToDtoFailedTransformationException;

public class InvoiceOutMapper
{
    private static InvoiceOutMapper invoiceOutMapper = null;

    private InvoiceOutMapper(){}

    public static InvoiceOutMapper getInstance()
    {
        if (invoiceOutMapper == null)
            invoiceOutMapper = new InvoiceOutMapper();

        return invoiceOutMapper;
    }

    public InvoiceOutDto entityToDto(InvoiceOut invoiceOut) throws EntityToDtoFailedTransformationException
    {
        return InvoiceOutDto.builder()
                .invoiceOutDto(invoiceOut.getInvoiceOutId())
                .codeDto(invoiceOut.getCode())
                .dateDto(invoiceOut.getDate())
                .articleNumberDto(invoiceOut.getArticleNumber())
                .productNameDto(invoiceOut.getProductName())
                .unitOfMeasureDto(invoiceOut.getUnitOfMeasure())
                .quantityDto(invoiceOut.getQuantity())
                .unitaryPriceDto(invoiceOut.getUnitaryPrice())
                .valueWithoutTvaDto(invoiceOut.getValueWithoutTva())
                .valueWithTvaDto(invoiceOut.getValueWithTva())
                .build();
    }

    public InvoiceOut dtoToEntity(InvoiceOutDto invoiceOutDto) throws DtoToEntityFailedTransformationException
    {
        return InvoiceOut.builder()
                .invoiceOutId(invoiceOutDto.getInvoiceOutDto())
                .code(invoiceOutDto.getCodeDto())
                .date(invoiceOutDto.getDateDto())
                .articleNumber(invoiceOutDto.getArticleNumberDto())
                .productName(invoiceOutDto.getProductNameDto())
                .unitOfMeasure(invoiceOutDto.getUnitOfMeasureDto())
                .quantity(invoiceOutDto.getQuantityDto())
                .unitaryPrice(invoiceOutDto.getUnitaryPriceDto())
                .valueWithoutTva(invoiceOutDto.getValueWithoutTvaDto())
                .valueWithTva(invoiceOutDto.getValueWithTvaDto())
                .build();
    }
}
