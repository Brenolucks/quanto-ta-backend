package com.cvckcorp.backend_quanto_ta.domain.dto;

import java.util.List;

public record NfceResponseDto(NfceEmitenteResponseDto emitente, List<NfceProdutoResponseDto> produtos) {
}
