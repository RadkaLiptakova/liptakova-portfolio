package com.ictdemy.models.services;

import com.ictdemy.models.dto.ProductDTO;

import java.util.List;

/**
 * Service interface for managing products.
 * This interface defines the methods for creating, retrieving, updating, and deleting products
 * in the application. It uses {@link ProductDTO} as a Data Transfer Object (DTO) to transfer
 * product data between layers.
 */
public interface ProductService {

    /**
     * Creates a new product.
     *
     * @param product the product data to be created.
     */
    void create(ProductDTO product);

    /**
     * Retrieves all products.
     *
     * @return a list of all products as {@link ProductDTO}.
     */
    List<ProductDTO> getAll();

    /**
     * Retrieves a product by its unique ID.
     *
     * @param id the ID of the product to retrieve.
     * @return the {@link ProductDTO} representing the product with the given ID.
     */
    ProductDTO getById(long id);

    /**
     * Edits an existing product.
     *
     * @param product the updated product data.
     */
    void edit(ProductDTO product);

    /**
     * Removes a product by its unique ID.
     *
     * @param id the ID of the product to be removed.
     */
    void remove(long id);
}
