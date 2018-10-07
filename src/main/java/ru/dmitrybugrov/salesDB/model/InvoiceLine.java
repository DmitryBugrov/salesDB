package ru.dmitrybugrov.salesDB.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class InvoiceLine {

    @Id
    @GeneratedValue
    private Long Id;

    private Product product;

    private Integer quantity;

    private float discount;

    public InvoiceLine(Product product, Integer quantity, float discount) {
        this.product = product;
        this.quantity = quantity;
        this.discount = discount;
    }
}
