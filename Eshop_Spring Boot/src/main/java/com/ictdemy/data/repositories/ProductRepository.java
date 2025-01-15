package com.ictdemy.data.repositories;

import com.ictdemy.data.entities.ProductEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository interface for managing {@link ProductEntity} instances.
 * This interface provides CRUD operations for {@link ProductEntity}.
 * It extends the {@link CrudRepository} interface provided by Spring Data JPA.
 */
public interface ProductRepository extends CrudRepository<ProductEntity,Long> {
}
