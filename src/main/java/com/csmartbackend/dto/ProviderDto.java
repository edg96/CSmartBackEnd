package com.csmartbackend.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Builder
@Setter
@Getter
public class ProviderDto
{
    private UUID providerIdDto;
    private String fiscalCodeDto;
    public AddressDto addressDto;
}
