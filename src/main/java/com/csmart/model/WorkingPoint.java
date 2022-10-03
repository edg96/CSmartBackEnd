package com.csmart.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;
import java.util.UUID;

@Entity
@Builder
@Getter
@Setter
@Table(name = "workingPoint")
@NoArgsConstructor
@AllArgsConstructor
public class WorkingPoint
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    private UUID workingPointId;

    @Pattern(regexp = "\\d+", message = "Invalid \"Fiscal Code\". Wrong format!")
    @Size(min = 8, max = 8, message = "Invalid \"Fiscal Code\". It must contain 8 characters exactly.")
    private String fiscalCode;

    @NotNull(message = "Invalid \"Code\". It can't be null.")
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "workingpoint_address",
            joinColumns = @JoinColumn(name = "id_workingpoint"),
            inverseJoinColumns = @JoinColumn(name = "id_address")
    )
    public Address address;

    @NotNull(message = "Invalid \"Code\". It can't be null.")
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "workingpoint_employee",
            joinColumns = @JoinColumn(name = "id_company"),
            inverseJoinColumns = @JoinColumn(name = "id_employee")
    )
    public Set<Employee> employees;
}
