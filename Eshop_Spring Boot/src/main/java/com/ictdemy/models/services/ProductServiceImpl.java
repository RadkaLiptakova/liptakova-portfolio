package com.ictdemy.models.services;

import com.ictdemy.data.entities.ProductEntity;
import com.ictdemy.data.repositories.ProductRepository;
import com.ictdemy.models.dto.ProductDTO;
import com.ictdemy.models.dto.mappers.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

/**
 * Implementation of the {@link ProductService} interface for managing products.
 * This service provides methods to create, retrieve, update, and delete products.
 * It interacts with the {@link ProductRepository} to perform CRUD operations and
 * uses {@link ProductMapper} to convert between {@link ProductDTO} and {@link ProductEntity}.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    /**
     * Creates a new product in the repository.
     *
     * @param product the product data to be saved.
     */
    @Override
    public void create(ProductDTO product) {
        ProductEntity newProduct = productMapper.toEntity(product);

        productRepository.save(newProduct);
    }

    /**
     * Retrieves all products from the repository.
     *
     * @return a list of all products as {@link ProductDTO}.
     */
    @Override
    public List<ProductDTO> getAll() {
        return StreamSupport.stream(productRepository.findAll().spliterator(), false)
                .map(i -> productMapper.toDTO(i))
                .toList();

    }

    /**
     * Retrieves a product by its unique ID.
     *
     * @param id the ID of the product to retrieve.
     * @return the {@link ProductDTO} representing the product with the given ID.
     * @throws RuntimeException if the product with the specified ID is not found.
     */
    @Override
    public ProductDTO getById(long id) {
        ProductEntity fetchedProduct = getProductOrThrow(id);

        return productMapper.toDTO(fetchedProduct);
    }

    /**
     * Edits an existing product.
     *
     * @param product the updated product data.
     * @throws RuntimeException if the product with the specified ID is not found.
     */
    @Override
    public void edit(ProductDTO product) {
        ProductEntity fetchedProduct = getProductOrThrow(product.getId());

        productMapper.updateProductEntity(product, fetchedProduct);
        productRepository.save(fetchedProduct);
    }

    /**
     * Removes a product by its unique ID.
     *
     * @param id the ID of the product to be deleted.
     * @throws RuntimeException if the product with the specified ID is not found.
     */
    @Override
    public void remove(long id) {
        ProductEntity fetchedProduct = getProductOrThrow(id);
        productRepository.delete(fetchedProduct);
    }

    /**
     * Retrieves a product by its unique ID or throws an exception if not found.
     *
     * @param id the ID of the product to fetch.
     * @return the {@link ProductEntity} corresponding to the given ID.
     * @throws RuntimeException if the product with the specified ID is not found.
     */
    private ProductEntity getProductOrThrow(long id) {
        return productRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + id));
    }
}
