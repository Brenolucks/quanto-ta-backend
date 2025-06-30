package com.cvckcorp.backend_quanto_ta.service.company;

import com.cvckcorp.backend_quanto_ta.domain.dto.NfceCompanyRequestDto;
import com.cvckcorp.backend_quanto_ta.domain.dto.NfceCompanyResponseDto;
import com.cvckcorp.backend_quanto_ta.domain.model.Company;
import com.cvckcorp.backend_quanto_ta.domain.pojo.NfceNfeProcPOJO;
import org.jsoup.nodes.Document;

public interface CompanyService {
    NfceCompanyResponseDto getCompanyFields(NfceNfeProcPOJO document);
    long saveCompany(NfceCompanyRequestDto nfceCompanyRequestDto);
}
