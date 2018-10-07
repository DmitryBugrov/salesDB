package ru.dmitrybugrov.salesDB.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.dmitrybugrov.salesDB.model.InvoiceLine;

public interface InvoiceLineRepository extends CrudRepository<InvoiceLine,Long> {

}
