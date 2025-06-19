package com.cvckcorp.backend_quanto_ta.service.company;

import com.cvckcorp.backend_quanto_ta.domain.dto.NfceCompanyResponseDto;
import org.jsoup.nodes.Document;

public interface CompanyService {
    NfceCompanyResponseDto getCompanyFields(Document document);
}
