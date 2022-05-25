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
@Table(name = "provider")
@NoArgsConstructor
@AllArgsConstructor
public class Provider
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    private UUID providerId;

    @NotNull(message = "Invalid \"Fiscal Code\". It can't be null.")
    @NotBlank(message = "Invalid \"Fiscal Code\". It can't be empty.")
    @Pattern(regexp = "\\d+", message = "Invalid \"Fiscal Code\". Wrong format!")
    @Size(min = 8, max = 8)
    private String fiscalCode;

    @NotNull(message = "Invalid \"Address\". It can't be null.")
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "provider_address",
            joinColumns = @JoinColumn(name = "id_provider"),
            inverseJoinColumns = @JoinColumn(name = "id_address")
    )
    public Address address;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "provider_invoiceIn",
            joinColumns = @JoinColumn(name = "id_provider"),
            inverseJoinColumns = @JoinColumn(name = "id_invoiceIn")
    )
    public Set<InvoiceIn> invoiceIns;
}
