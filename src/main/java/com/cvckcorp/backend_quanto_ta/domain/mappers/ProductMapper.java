package com.cvckcorp.backend_quanto_ta.domain.mappers;

import com.cvckcorp.backend_quanto_ta.domain.dto.NfceProductRequestDto;
import com.cvckcorp.backend_quanto_ta.domain.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    NfceProductRequestDto toDTO (Product product);
    Product toEntity(NfceProductRequestDto nfceProductRequestDto);
    Product toEntityWithCompanyID(NfceProductRequestDto nfceProductRequestDto, long idCompany);
}
