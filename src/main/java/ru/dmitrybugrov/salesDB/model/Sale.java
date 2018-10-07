package ru.dmitrybugrov.salesDB.model;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Sale {

    @NotNull
    @GeneratedValue
    private Long Id;

    @NotNull
    private Date date;

    private List<InvoiceLine> lineList;

    public Sale(List<InvoiceLine> lineList) {
        this.lineList = lineList;
        this.date=new Date();
    }
}
