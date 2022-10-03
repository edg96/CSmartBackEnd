package com.csmart.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.util.UUID;

@Entity
@Builder
@Getter
@Setter
@Table(name = "address")
@NoArgsConstructor
@AllArgsConstructor
public class Address
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    private UUID addressId;

    @NotNull(message = "Invalid \"County\". It can't be null.")
    @NotBlank(message = "Invalid \"County\". It can't be empty.")
    @Pattern(regexp="^[a-zA-Z\\s]*$", message = "Invalid \"County\". Wrong format.")
    private String county;

    @NotNull(message = "Invalid \"Locality\". It can't be null.")
    @NotBlank(message = "Invalid \"Locality\". It can't be empty.")
    @Pattern(regexp="^[a-zA-Z\\s]*$", message = "Invalid \"Locality\". Wrong format!")
    private String locality;


    @NotNull(message = "Invalid \"Street\". It can't be null.")
    @NotBlank(message = "Invalid \"Street\". It can't be empty.")
    @Pattern(regexp="^[a-zA-Z\\s]*$", message = "Invalid \"Street\". Wrong format!")
    private String street;


    @NotNull(message = "Invalid \"Street Number\". It can't be null.")
    @NotBlank(message = "Invalid \"Street Number\". It can't be empty.")
    @Pattern(regexp="^[A-Za-z\\d_-]*$", message = "Invalid \"Street Number\". Wrong format!")
    private String streetNumber;

    @Pattern(regexp="^[A-Za-z\\d_-]*$", message = "Invalid \"Block Number\". Wrong format!")
    private String blockNumber;

    @Pattern(regexp="^[A-Za-z\\d_-]*$", message = "Invalid \"Stair Number\". Wrong format!")
    private String stairNumber;

    @Positive(message = "Invalid \"Floor\". It must pe positive.")
    private int floor;

//    @Positive(message = "Invalid \"Apartment Number\". It must pe positive.")
    private int apartmentNumber;
}
