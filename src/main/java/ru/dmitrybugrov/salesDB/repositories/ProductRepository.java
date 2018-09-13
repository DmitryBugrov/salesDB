package ru.dmitrybugrov.salesDB.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.dmitrybugrov.salesDB.model.Product;

public interface ProductRepository extends CrudRepository<Product,Long> {
}
