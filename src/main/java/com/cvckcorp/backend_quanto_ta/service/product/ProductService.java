package com.cvckcorp.backend_quanto_ta.service.product;

import com.cvckcorp.backend_quanto_ta.domain.dto.NfceProductRequestDto;
import com.cvckcorp.backend_quanto_ta.domain.dto.NfceProductResponseDto;
import org.jsoup.nodes.Document;

import java.util.List;

public interface ProductService {
    List<NfceProductResponseDto> getProductFields(Document document);
    //void saveProduct(NfceProductRequestDto nfceProductRequestDto);
}
