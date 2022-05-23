package com.csmartbackend.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;
import java.util.UUID;

@Entity
@Builder
@Getter
@Setter
@Table(name = "company")
@NoArgsConstructor
@AllArgsConstructor
public class Company
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    private UUID companyId;

    @NotNull(message = "Invalid \"Register Number\". It can't be null.")
    @NotBlank(message = "Invalid \"Register Number\". It can't be empty.")
    private String registerNumber;

    @NotNull(message = "Invalid \"Fiscal Code\". It can't be null.")
    @NotBlank(message = "Invalid \"Fiscal Code\". It can't be empty.")
    @Pattern(regexp = "[0-9]+", message = "Invalid \"Fiscal Code\". Wrong format!")
    @Size(min = 8, max = 8)
    private String fiscalCode;

    @NotNull(message = "Invalid \"Address\". It can't be null.")
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "company_address",
            joinColumns = @JoinColumn(name = "id_company"),
            inverseJoinColumns = @JoinColumn(name = "id_address")
    )
    public Address address;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "company_workingpoint",
            joinColumns = @JoinColumn(name = "id_company"),
            inverseJoinColumns = @JoinColumn(name = "id_workingpoint")
    )
    public Set<WorkingPoint> workingPoints;
    //transfera angajatii catre alte puncte de lucru sau elimina
}
