package com.cvckcorp.backend_quanto_ta.service.company;

import com.cvckcorp.backend_quanto_ta.domain.dto.NfceCompanyRequestDto;
import com.cvckcorp.backend_quanto_ta.domain.dto.NfceCompanyResponseDto;
import com.cvckcorp.backend_quanto_ta.domain.model.Company;
import com.cvckcorp.backend_quanto_ta.repositories.CompanyRepository.CompanyRepository;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public NfceCompanyResponseDto getCompanyFields(Document document) {
        NfceCompanyResponseDto company = null;
        for(Element e : document.select("emit")) {
             company = new NfceCompanyResponseDto(
                    e.getElementsByTag("CNPJ").text(),
                     e.getElementsByTag("xNome").text(),
                     e.getElementsByTag("xFant").text(),
                     e.select("enderEmit > xLgr").text(),
                    e.select("enderEmit > nro").text()
            );
        }

        return company;
    }

    @Override
    public void saveCompany(NfceCompanyRequestDto nfceCompanyRequestDto) {
        var company = new Company();
        company.setCnpj(nfceCompanyRequestDto.cnpj());
        company.setName(nfceCompanyRequestDto.name());
        company.setFantasia(nfceCompanyRequestDto.fant());
        company.setAddress(nfceCompanyRequestDto.address());
        company.setNumber(nfceCompanyRequestDto.number());

        companyRepository.save(company);
    }
}
