package com.csmart.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Builder
@Getter
@Setter
public class CompanyDto
{
    private UUID companyIdDto;
    private String registerNumberDto;
    private String fiscalCodeDto;
    public AddressDto addressDto;
    public Set<WorkingPointDto> workingPointsDto;
}
