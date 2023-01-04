package com.csmart.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Builder
@Getter
@Setter
public class ContractDto
{
    private UUID contractIdDto;
    private String contractTypeDto;
    private int workHoursPerDayDto;
    private int legalDaysOffDto;
    private double brutSalaryDto;
}
