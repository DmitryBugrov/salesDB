package ru.dmitrybugrov.salesDB.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.dmitrybugrov.salesDB.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product,Long> {
     List<Product> findByName(String name);
     Optional<Product> findById(Long id);
}
