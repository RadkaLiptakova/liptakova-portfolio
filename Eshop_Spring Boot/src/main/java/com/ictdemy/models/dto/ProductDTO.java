package com.ictdemy.models.dto;

/**
 * Data Transfer Object (DTO) representing a product.
 * This class is used to transfer product data between layers (such as the service layer
 * and the controller) in a format suitable for the client.
 */
public class ProductDTO {

    /**
     * The unique identifier for the product.
     * This field corresponds to the product's ID in the database.
     */
    private long id;

    /**
     * The name of the product.
     * This field represents the product's name.
     */
    private String name;

    /**
     * A description of the product.
     * This field provides additional information about the product.
     */
    private String description;

    /**
     * The price of the product.
     * This field represents the price of the product.
     */
    private double price;

    /**
     * Gets the product's unique identifier.
     *
     * @return the product ID.
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the product's unique identifier.
     *
     * @param id the product ID.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets the product's name.
     *
     * @return the product name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the product's name.
     *
     * @param name the product name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the product's description.
     *
     * @return the product description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the product's description.
     *
     * @param description the product description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the product's price.
     *
     * @return the product price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the product's price.
     *
     * @param price the product price.
     */
    public void setPrice(double price) {
        this.price = price;
    }
}
