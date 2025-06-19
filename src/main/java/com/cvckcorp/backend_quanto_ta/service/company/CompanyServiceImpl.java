package com.cvckcorp.backend_quanto_ta.service.company;

import com.cvckcorp.backend_quanto_ta.domain.dto.NfceCompanyResponseDto;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Override
    public NfceCompanyResponseDto getCompanyFields(Document document) {
        NfceCompanyResponseDto company = null;
        for(Element e : document.select("emit")) {
             company = new NfceCompanyResponseDto(
                    e.getElementsByTag("CNPJ").text(),
                    e.getElementsByTag("xFant").text(),
                    e.select("enderEmit > xLgr").text(),
                    e.select("enderEmit > nro").text()
            );
        }

        return company;
    }
}
