package ru.dmitrybugrov.salesDB.model;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long        id;
    @NotNull
    private String name;
    @NotNull
    private Double price;
    private float  discount;

    public Product() {
    }

    public Product(String name, Double price, float discount) {
        this.name = name;
        this.price = price;
        this.discount = discount;
    }
}
