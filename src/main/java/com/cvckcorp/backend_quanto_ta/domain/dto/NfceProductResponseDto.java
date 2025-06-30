package com.cvckcorp.backend_quanto_ta.domain.dto;

public record NfceProductResponseDto(String code, String name, String unit,
                                     double amount, double price) {
}
