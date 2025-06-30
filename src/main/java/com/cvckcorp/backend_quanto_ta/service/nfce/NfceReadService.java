package com.cvckcorp.backend_quanto_ta.service.nfce;

import com.cvckcorp.backend_quanto_ta.domain.dto.NfceRequestDto;
import com.cvckcorp.backend_quanto_ta.domain.dto.NfceResponseDto;

import com.cvckcorp.backend_quanto_ta.domain.pojo.NfceNfeProcPOJO;

public interface NfceReadService {
    NfceResponseDto nfceDocumentReaded(NfceNfeProcPOJO document);
    String registerNfce(NfceRequestDto nfceRequestDto);
}
