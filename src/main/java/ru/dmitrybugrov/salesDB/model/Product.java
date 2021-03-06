package ru.dmitrybugrov.salesDB.model;

import lombok.Data;
import lombok.NonNull;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Entity
public class Product {

    /**
     * Uniq Id of Product, value is autogenerated
     */
    @Id
    @GeneratedValue
    private Long        id;

    /**
     * Uniq name of Product
     */
    @NotNull
    @Column(unique = true)
    private String name;

    /**
     * price of Product
     */
    @NotNull
    private Double price;

    /**
     * discount
     */
    private float  discount;

    public Product() {
    }

    public Product(String name, Double price, float discount) {
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }
}
