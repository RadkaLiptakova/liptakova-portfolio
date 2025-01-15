package com.ictdemy.models.dto.mappers;

import com.ictdemy.data.entities.ProductEntity;
import com.ictdemy.models.dto.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

/**
 * Mapper interface for converting between {@link ProductEntity} and {@link ProductDTO}.
 * This interface uses MapStruct to automatically generate the mapping code between the
 * entity and DTO classes. The mappings are used to transfer data between the database
 * layer and the service layer of the application.
 */
@Mapper(componentModel = "spring")
public interface ProductMapper {

    /**
     * Converts a {@link ProductDTO} to a {@link ProductEntity}.
     *
     * @param source the source {@link ProductDTO} object to convert.
     * @return the mapped {@link ProductEntity} object.
     */
    ProductEntity toEntity(ProductDTO source);

    /**
     * Converts a {@link ProductEntity} to a {@link ProductDTO}.
     *
     * @param source the source {@link ProductEntity} object to convert.
     * @return the mapped {@link ProductDTO} object.
     */
    ProductDTO toDTO(ProductEntity source);

    /**
     * Updates the target {@link ProductDTO} with values from the source {@link ProductDTO}.
     * This method is used to partially update an existing {@link ProductDTO}.
     *
     * @param source the source {@link ProductDTO} containing the updated values.
     * @param target the target {@link ProductDTO} to be updated.
     */
    void updateProductDTO(ProductDTO source, @MappingTarget ProductDTO target);

    /**
     * Updates the target {@link ProductEntity} with values from the source {@link ProductDTO}.
     * This method is used to partially update an existing {@link ProductEntity}.
     *
     * @param source the source {@link ProductDTO} containing the updated values.
     * @param target the target {@link ProductEntity} to be updated.
     */
    void updateProductEntity(ProductDTO source, @MappingTarget ProductEntity target);
}
