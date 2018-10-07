package ru.dmitrybugrov.salesDB.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.dmitrybugrov.salesDB.model.Sale;

public interface SaleRepository extends CrudRepository<Sale,Long> {
}
