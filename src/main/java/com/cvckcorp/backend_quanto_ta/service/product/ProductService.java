package com.cvckcorp.backend_quanto_ta.service.product;

import com.cvckcorp.backend_quanto_ta.domain.dto.NfceProductRequestDto;
import com.cvckcorp.backend_quanto_ta.domain.dto.NfceProductResponseDto;
import com.cvckcorp.backend_quanto_ta.domain.pojo.NfceNfeProcPOJO;

import java.util.List;

public interface ProductService {
    List<NfceProductResponseDto> getProductFields(NfceNfeProcPOJO document);
    String saveProducts(List<NfceProductRequestDto> nfceProductRequestDto, long companyID);
}
