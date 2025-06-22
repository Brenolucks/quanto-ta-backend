package com.cvckcorp.backend_quanto_ta.service.nfce;

import com.cvckcorp.backend_quanto_ta.domain.dto.NfceRequestDto;
import com.cvckcorp.backend_quanto_ta.domain.dto.NfceResponseDto;

import org.jsoup.nodes.*;

public interface NfceReadService {
    NfceResponseDto nfceDocumentReaded(Document document);
    String registerNfce(NfceRequestDto nfceRequestDto);
}
