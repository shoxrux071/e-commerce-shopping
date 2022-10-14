package org.example.mapper;

import org.example.domains.Product;
import org.example.dto.ProductCreateDto;
import org.mapstruct.Mapper;



@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product fromCreateDto(ProductCreateDto dto);

}
