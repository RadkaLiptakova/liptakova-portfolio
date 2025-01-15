package com.ictdemy.models.dto.mappers;

import com.ictdemy.data.entities.ProductEntity;
import com.ictdemy.models.dto.ProductDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-14T13:40:49+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductEntity toEntity(ProductDTO source) {
        if ( source == null ) {
            return null;
        }

        ProductEntity productEntity = new ProductEntity();

        productEntity.setId( source.getId() );
        productEntity.setName( source.getName() );
        productEntity.setDescription( source.getDescription() );
        productEntity.setPrice( source.getPrice() );

        return productEntity;
    }

    @Override
    public ProductDTO toDTO(ProductEntity source) {
        if ( source == null ) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        productDTO.setId( source.getId() );
        productDTO.setName( source.getName() );
        productDTO.setDescription( source.getDescription() );
        productDTO.setPrice( source.getPrice() );

        return productDTO;
    }

    @Override
    public void updateProductDTO(ProductDTO source, ProductDTO target) {
        if ( source == null ) {
            return;
        }

        target.setId( source.getId() );
        target.setName( source.getName() );
        target.setDescription( source.getDescription() );
        target.setPrice( source.getPrice() );
    }

    @Override
    public void updateProductEntity(ProductDTO source, ProductEntity target) {
        if ( source == null ) {
            return;
        }

        target.setId( source.getId() );
        target.setName( source.getName() );
        target.setDescription( source.getDescription() );
        target.setPrice( source.getPrice() );
    }
}
