package com.cvckcorp.backend_quanto_ta.domain.dto;

import java.util.List;

public record NfceResponseDto(NfceCompanyResponseDto company, List<NfceProductResponseDto> products) {
}
