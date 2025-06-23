package com.cvckcorp.backend_quanto_ta.controller;

import com.cvckcorp.backend_quanto_ta.domain.dto.NfceRequestDto;
import com.cvckcorp.backend_quanto_ta.domain.dto.NfceResponseDto;
import com.cvckcorp.backend_quanto_ta.service.nfce.NfceReadServiceImpl;
import com.cvckcorp.backend_quanto_ta.utils.ReadURL;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class NfceController {
    private final ReadURL readURL;
    private final NfceReadServiceImpl nfceReadService;

    public NfceController(ReadURL readURL, NfceReadServiceImpl nfceReadService) {
        this.readURL = readURL;
        this.nfceReadService = nfceReadService;
    }

    @PostMapping("/read-nfce-link")
    public ResponseEntity<NfceResponseDto> readNfceLink(@RequestBody String url) {
        try {
            var document = readURL.ReadUrlFromLink(url);
            var documentReaded = nfceReadService.nfceDocumentReaded(document);

            return ResponseEntity.status(HttpStatus.OK).body(documentReaded);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/register-nfce")
    public ResponseEntity<String> registerNfce(@RequestBody NfceRequestDto nfceRequestDto) {
        try {
            var response = nfceReadService.registerNfce(nfceRequestDto);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
