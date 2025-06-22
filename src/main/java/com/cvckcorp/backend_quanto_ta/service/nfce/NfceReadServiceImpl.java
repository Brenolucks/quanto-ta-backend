package com.cvckcorp.backend_quanto_ta.service.nfce;

import com.cvckcorp.backend_quanto_ta.domain.dto.NfceRequestDto;
import com.cvckcorp.backend_quanto_ta.domain.dto.NfceResponseDto;
import com.cvckcorp.backend_quanto_ta.service.company.CompanyServiceImpl;
import com.cvckcorp.backend_quanto_ta.service.product.ProductServiceImpl;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

@Service
public class NfceReadServiceImpl implements NfceReadService {
    private final CompanyServiceImpl companyService;
    private final ProductServiceImpl productService;

    public NfceReadServiceImpl(CompanyServiceImpl companyService, ProductServiceImpl productService) {
        this.companyService = companyService;
        this.productService = productService;
    }

    @Override
    public NfceResponseDto nfceDocumentReaded(Document document) {
        var company = companyService.getCompanyFields(document);
        var product = productService.getProductFields(document);

        return new NfceResponseDto(company, product);
    }

    @Override
    public String registerNfce(NfceRequestDto nfceRequestDto) {
        var company = companyService.saveCompany(nfceRequestDto.nfceCompanyRequestDto());
        var product = productService.saveProducts(nfceRequestDto.nfceProductRequestDto());

        return "Save with success!";
    }
}
