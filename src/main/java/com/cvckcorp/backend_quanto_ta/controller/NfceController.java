package com.cvckcorp.backend_quanto_ta.controller;

import com.cvckcorp.backend_quanto_ta.domain.dto.NfceProdutoResponseDto;
import com.cvckcorp.backend_quanto_ta.domain.dto.NfceRequestDto;
import com.cvckcorp.backend_quanto_ta.domain.dto.NfceEmitenteResponseDto;
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
            System.out.println("RESULTADO: " + result);
            Document doc = Jsoup.parse(String.valueOf(result), "", Parser.xmlParser());
            NfceEmitenteResponseDto emitente = null;
            List<NfceProdutoResponseDto> produto = new ArrayList<>();
            NfceResponseDto resultado = null;
            System.out.println(doc);
            for(Element e : doc.select("emit")) {
                emitente = new NfceEmitenteResponseDto(
                        e.getElementsByTag("CNPJ").text(),
                        e.getElementsByTag("xNome").text(),
                        e.getElementsByTag("xFant").text(),
                        e.select("enderEmit > xLgr").text(),
                        e.select("enderEmit > nro").text()
                );
                System.out.println("Emitente: " + emitente);
            }

            for(Element e : doc.getElementsByTag("det")) {
                var prod = new NfceProdutoResponseDto(e.getElementsByTag("cProd").text(), e.getElementsByTag("xProd").text(),
                                                      e.getElementsByTag("uCom").text(), e.getElementsByTag("qCom").text(),
                                                      e.getElementsByTag("vProd").text());
                produto.add(prod);
                System.out.println("PRODUTO: " + produto);
            }

            resultado = new NfceResponseDto(emitente, produto);

            return ResponseEntity.status(HttpStatus.OK).body(resultado);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
