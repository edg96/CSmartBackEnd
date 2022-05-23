package com.csmartbackend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.UUID;

@Entity
@Builder
@Getter
@Setter
@Table(name = "invoiceIn")
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceIn
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    private UUID invoiceInId;

    @NotNull(message = "Invalid \"Code\". It can't be null.")
    @NotBlank(message = "Invalid \"Code\". It can't be empty.")
    @Pattern(regexp="^[A-Za-z\\d_-]*$", message = "Invalid \"Code\". Wrong format!")
    private String code;

    @NotNull(message = "Invalid \"Date\". It can't be null.")
    @NotBlank(message = "Invalid \"Date\". It can't be empty.")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private String date;

    @NotNull(message = "Invalid \"Article Number\". It can't be null.")
    @Positive
    @Min(1)
    private int articleNumber;

    @NotNull(message = "Invalid \"Product Name\". It can't be null.")
    @NotBlank(message = "Invalid \"Product Name\". It can't be empty.")
    private String productName;

    @NotNull(message = "Invalid \"Unit Of Measure\". It can't be null.")
    @Enumerated(EnumType.STRING)
    private UnitOfMeasureType unitOfMeasure;

    @NotNull(message = "Invalid \"Quantity\". It can't be null.")
    @Positive(message = "Invalid \"Quantity\". It must be positive.")
    private int quantity;

    @NotNull(message = "Invalid \"Unitary Price\". It can't be null.")
    private double unitaryPrice;

    @NotNull(message = "Invalid \"Value Without TVA\". It can't be null.")
    private double valueWithoutTva;

    @NotNull(message = "Invalid \"Value With TVA\". It can't be null.")
    private double valueWithTva;

    public enum UnitOfMeasureType {
        BUC, ST, L, KG
    }
}