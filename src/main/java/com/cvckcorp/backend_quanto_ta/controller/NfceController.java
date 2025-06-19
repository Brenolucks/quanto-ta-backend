package com.cvckcorp.backend_quanto_ta.controller;

import com.cvckcorp.backend_quanto_ta.domain.dto.NfceCompanyResponseDto;
import com.cvckcorp.backend_quanto_ta.domain.dto.NfceProductResponseDto;
import com.cvckcorp.backend_quanto_ta.domain.dto.NfceRequestDto;
import com.cvckcorp.backend_quanto_ta.domain.dto.NfceResponseDto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;


@RestController
@RequestMapping(value = "/api")
public class NfceController {
    @PostMapping("/read-nfce-link")
    public ResponseEntity<NfceResponseDto> readNfceLink(@RequestBody NfceRequestDto nfceRequestDto) {

        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> result = restTemplate.getForEntity(nfceRequestDto.url(), String.class);
            Document doc = Jsoup.parse(String.valueOf(result), "", Parser.xmlParser());

            NfceCompanyResponseDto company = null;
            List<NfceProductResponseDto> product = new ArrayList<>();
            NfceResponseDto responseDto = null;

            for(Element e : doc.select("emit")) {
                company = new NfceCompanyResponseDto(
                        e.getElementsByTag("CNPJ").text(),
                        e.getElementsByTag("xFant").text(),
                        e.select("enderEmit > xLgr").text(),
                        e.select("enderEmit > nro").text()
                );
            }

            for(Element e : doc.getElementsByTag("det")) {
                var products = new NfceProductResponseDto(e.getElementsByTag("cProd").text(), e.getElementsByTag("xProd").text(),
                                                      e.getElementsByTag("uCom").text(), e.getElementsByTag("qCom").text(),
                                                      e.getElementsByTag("vProd").text());
                product.add(products);
            }

            responseDto = new NfceResponseDto(company, product);

            return ResponseEntity.status(HttpStatus.OK).body(responseDto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
