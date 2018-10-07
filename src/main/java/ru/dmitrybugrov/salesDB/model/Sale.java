package ru.dmitrybugrov.salesDB.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Sale {

    @NotNull
    @GeneratedValue
    @Id
    private Long Id;

    @NotNull
    private Date date;

    @OneToMany
    private List<InvoiceLine> lineList;

    public Sale(List<InvoiceLine> lineList) {
        this.lineList = lineList;
        this.date=new Date();
    }
}
