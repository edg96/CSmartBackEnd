package com.csmartbackend.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.UUID;

@Entity
@Builder
@Getter
@Setter
@Table(name = "contracts")
@NoArgsConstructor
@AllArgsConstructor
public class Contract
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    private UUID contractId;

    @NotNull(message = "Invalid \"Contract Type\". It can't be null.")
    private String contractType;

    @NotNull(message = "Invalid \"Work Hours Per Day\". It can't be null.")
    @Positive(message = "Invalid \"Work Hours Per Day\". It must be positive.")
    private int workHoursPerDay;

    @NotNull(message = "Invalid \"Legal Days Off\". It can't be null.")
    @Positive(message = "Invalid \"Legal Days Off\". It must be positive.")
    @Min(value = 20, message = "Invalid \"Legal Days Off\". It must be equal to 20 or higher.")
    private int legalDaysOff;

    @NotNull(message = "Invalid \"Brut Salary\". It can't be null.")
    @Positive(message = "Invalid \"Brut Salary\". It must be positive.")
    private double brutSalary;

    public enum ContractType {
        FULLTIME, PARTTIME, ZILIER
    }
}
