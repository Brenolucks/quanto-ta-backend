package com.cvckcorp.backend_quanto_ta.controller;

import com.cvckcorp.backend_quanto_ta.domain.dto.NfceRequestDto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;


@RestController
@RequestMapping(value = "/api")
public class NfceController {
    @PostMapping("/read-nfce-link")
    public ResponseEntity<String> readNfceLink(@RequestBody NfceRequestDto nfceRequestDto) {
        HashMap<String, String> produto = null;
        HashMap<String, String> emitente = null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> result = restTemplate.getForEntity(nfceRequestDto.url(), String.class);
            System.out.println("RESULTADO: " + result);
            Document doc = Jsoup.parse(String.valueOf(result), "", Parser.xmlParser());

            for(Element e : doc.select("emit")) {
                emitente = new HashMap<>();
                emitente.put("cnpj", e.getElementsByTag("CNPJ").text());
                emitente.put("nome", e.getElementsByTag("xNome").text());
                emitente.put("fantasia", e.getElementsByTag("xFant").text());
                emitente.put("logradouro", e.select("enderEmit > xLgr").text());
                emitente.put("numero", e.select("enderEmit > nro").text());

                System.out.println("Emitente: " + emitente);
            }

            for(Element e : doc.getElementsByTag("det")) {
                produto = new HashMap<>();
                produto.put("codigo", e.getElementsByTag("cProd").text());
                produto.put("nome", e.getElementsByTag("xProd").text());
                produto.put("unidade", e.getElementsByTag("uCom").text());
                produto.put("quantidade", e.getElementsByTag("qCom").text());
                produto.put("preco", e.getElementsByTag("vProd").text());

                System.out.println("PRODUTO: " + produto);
            }

            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_XML).body(result.getBody());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao consultar a NFCE: " + e.getMessage());
        }
    }
}
