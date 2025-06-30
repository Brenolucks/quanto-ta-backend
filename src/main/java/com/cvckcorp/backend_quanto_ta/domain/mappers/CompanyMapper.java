package com.cvckcorp.backend_quanto_ta.domain.mappers;

import com.cvckcorp.backend_quanto_ta.domain.dto.NfceCompanyRequestDto;
import com.cvckcorp.backend_quanto_ta.domain.dto.NfceCompanyResponseDto;
import com.cvckcorp.backend_quanto_ta.domain.model.Company;
import com.cvckcorp.backend_quanto_ta.domain.pojo.NfceNfeProcPOJO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
    NfceCompanyRequestDto toDTO(Company company);
    Company toEntity(NfceCompanyRequestDto nfceCompanyRequestDto);

    @Mapping(source = "proc.nfeProc.NFe.infNFe.company.cnpj", target = "cnpj")
    @Mapping(source = "proc.nfeProc.NFe.infNFe.company.name", target = "name")
    @Mapping(source = "proc.nfeProc.NFe.infNFe.company.fant", target = "fant")
    @Mapping(source = "proc.nfeProc.NFe.infNFe.company.address.address", target = "address")
    @Mapping(source = "proc.nfeProc.NFe.infNFe.company.address.number", target = "number")
    NfceCompanyResponseDto toEntityByPOJO(NfceNfeProcPOJO document);


}
