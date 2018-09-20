package ru.dmitrybugrov.salesDB.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.dmitrybugrov.salesDB.model.Product;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product,Long> {
     List<Product> findByName(String name);
}
