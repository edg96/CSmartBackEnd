package com.csmart.mapper;

import com.csmart.dto.InvoiceOutDto;
import com.csmart.model.InvoiceOut;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InvoiceOutMapper
{
    InvoiceOutDto modelToDto(InvoiceOut InvoiceOut);
    List<InvoiceOutDto> modelToDtos(List<InvoiceOut> InvoiceOutList);
    InvoiceOut dtoToModel(InvoiceOutDto InvoiceOutDto);
}