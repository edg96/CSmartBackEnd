package com.csmart.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.UUID;

@Entity
@Builder
@Getter
@Setter
@Table(name = "employee")
@NoArgsConstructor
@AllArgsConstructor
public class Employee
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    private UUID employeeId;

    @NotNull(message = "Invalid \"CNP\". It can't be null.")
    @NotBlank(message = "Invalid \"CNP\". It can't be empty.")
    @Size(min = 12, max = 12, message = "Invalid \"CNP\". It must contain 12 characters exactly.")
    @Pattern(regexp = "\\d+", message = "Invalid \"CNP\". Wrong format!")
    private String cnp;

    @NotNull(message = "Invalid \"First Name\". It can't be null.")
    @NotBlank(message = "Invalid \"First Name\". It can't be empty.")
    @Pattern(regexp="^[A-Za-z]*$",message = "Invalid \"First Name\". Wrong format!")
    private String firstName;

    @NotNull(message = "Invalid \"Last Name\". It can't be null.")
    @NotBlank(message = "Invalid \"Last Name\". It can't be empty.")
    @Pattern(regexp="^[A-Za-z]*$",message = "Invalid \"Last Name\". Wrong format!")
    private String lastName;

    @NotNull(message = "Invalid \"Studies\". It can't be null.")
    @NotBlank(message = "Invalid \"Studies\". It can't be empty.")
    @Pattern(regexp="^[A-Za-z]*$",message = "Invalid \"Studies\". Wrong format!")
    private String studies;

    @NotNull(message = "Invalid \"Role\". It can't be null.")
    @NotBlank(message = "Invalid \"Role\". It can't be empty.")
    @Pattern(regexp="^[A-Za-z]*$",message = "Invalid \"Role\". Wrong format!")
    private String role;

    @NotNull(message = "Invalid \"Employment Date\". It can't be null.")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private Date employmentDate;

    @NotNull(message = "Invalid \"Address\". It can't be null.")
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "employee_address",
            joinColumns = @JoinColumn(name = "id_employee"),
            inverseJoinColumns = @JoinColumn(name = "id_address")
    )
    public Address address;

    @NotNull(message = "Invalid \"Contract\". It can't be null.")
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "employee_contract",
            joinColumns = @JoinColumn(name = "id_employee"),
            inverseJoinColumns = @JoinColumn(name = "id_contract")
    )
    public Contract contract;
}

