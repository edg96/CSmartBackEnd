package com.csmartbackend.mapper.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Builder
@Getter
@Setter
public class AddressDto
{
    private UUID addressIdDto;
    private String countyDto;
    private String localityDto;
    private String streetDto;
    private String streetNumberDto;
    private String blockNumberDto;
    private String stairNumberDto;
    private int floorDto;
    private int apartmentNumberDto;
}
