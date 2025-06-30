package com.cvckcorp.backend_quanto_ta.service.company;

import com.cvckcorp.backend_quanto_ta.domain.dto.NfceCompanyRequestDto;
import com.cvckcorp.backend_quanto_ta.domain.dto.NfceCompanyResponseDto;
import com.cvckcorp.backend_quanto_ta.domain.mappers.CompanyMapper;
import com.cvckcorp.backend_quanto_ta.domain.pojo.NfceNfeProcPOJO;
import com.cvckcorp.backend_quanto_ta.repositories.CompanyRepository.CompanyRepository;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    public CompanyServiceImpl(CompanyRepository companyRepository,
                              CompanyMapper companyMapper) {
        this.companyRepository = companyRepository;
        this.companyMapper = companyMapper;
    }

    @Override
    public NfceCompanyResponseDto getCompanyFields(NfceNfeProcPOJO document) {
        return companyMapper.toEntityByPOJO(document);
    }

    @Override
    public long saveCompany(NfceCompanyRequestDto nfceCompanyRequestDto) {
        return companyRepository.save(companyMapper.toEntity(nfceCompanyRequestDto)).getId();
    }
}
