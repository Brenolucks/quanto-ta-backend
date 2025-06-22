package com.cvckcorp.backend_quanto_ta.domain.dto;

public record NfceProductRequestDto(String code, String name, String unit,
                                    String amount, String price) {
}
