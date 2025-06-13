package com.codewithyash.store.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.codewithyash.store.dtos.ProductDto;  
import com.codewithyash.store.entities.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(source = "category.name", target = "categoryName")
    ProductDto toDto(Product product);
}

    
