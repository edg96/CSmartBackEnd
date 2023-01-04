package com.csmart.mapper;

import com.csmart.dto.InvoiceInDto;
import com.csmart.model.InvoiceIn;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InvoiceInMapper
{
    InvoiceInDto modelToDto(InvoiceIn InvoiceIn);
    List<InvoiceInDto> modelToDtos(List<InvoiceIn> InvoiceInList);
    InvoiceIn dtoToModel(InvoiceInDto InvoiceInDto);
}