package com.cvckcorp.backend_quanto_ta.domain.dto;

import java.util.List;

public record NfceRequestDto (NfceCompanyRequestDto nfceCompanyRequestDto, List<NfceProductRequestDto> nfceProductRequestDto){
}
