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
@Table(name = "invoiceOut")
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceOut
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    private UUID invoiceOutId;

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
    @NotBlank(message = "Invalid \"Article Number\". It can't be empty.")
    @Positive
    @Min(1)
    private int articleNumber;

    @NotNull(message = "Invalid \"Product Name\". It can't be null.")
    @NotBlank(message = "Invalid \"Product Name\". It can't be empty.")
    private String productName;

    @NotNull(message = "Invalid \"Unit Of Measure\". It can't be null.")
    @NotBlank(message = "Invalid \"Unit Of Measure\". It can't be empty.")
    @Pattern(regexp="^[A-Za-z]*$", message = "Invalid \"Unit Of Measure\". Wrong format!")
    private String unitOfMeasure;

    @NotNull(message = "Invalid \"Quantity\". It can't be null.")
    @NotBlank(message = "Invalid \"Quantity\". It can't be empty.")
    @Positive(message = "Invalid \"Quantity\". It must be positive.")
    private int quantity;

    @NotNull(message = "Invalid \"Unitary Price\". It can't be null.")
    @NotBlank(message = "Invalid \"Unitary Price\". It can't be empty.")
    private double unitaryPrice;

    @NotNull(message = "Invalid \"Value Without TVA\". It can't be null.")
    @NotBlank(message = "Invalid \"Value Without TVA\". It can't be empty.")
    private double valueWithoutTva;

    @NotNull(message = "Invalid \"Value With TVA\". It can't be null.")
    @NotBlank(message = "Invalid \"Value With TVA\". It can't be empty.")
    private double valueWithTva;

    public enum UnitOfMeasureType {
        BUC, ST, L, KG
    }
}
