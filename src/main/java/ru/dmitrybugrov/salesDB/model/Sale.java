package ru.dmitrybugrov.salesDB.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Sale {


    @GeneratedValue
    @Id
    private Long id;


    private Date date;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<InvoiceLine> lineList;

    public Sale(List<InvoiceLine> lineList) {
        this();
        this.lineList = lineList;

    }

    public Sale() {
        this.date=new Date();
    }
}
