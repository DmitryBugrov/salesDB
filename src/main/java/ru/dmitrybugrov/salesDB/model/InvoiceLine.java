package ru.dmitrybugrov.salesDB.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class InvoiceLine {

    @Id
    @GeneratedValue
    @NotNull
    private Long Id;

    @OneToOne
    private Product product;

    private Integer quantity;

    private float discount;

    public InvoiceLine(Product product, Integer quantity, float discount) {
        this.product = product;
        this.quantity = quantity;
        this.discount = discount;
    }
}
