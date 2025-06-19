package com.cvckcorp.backend_quanto_ta.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ReadURL {
    public Document ReadUrlFromLink(String url) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> result = restTemplate.getForEntity(url, String.class);

        return Jsoup.parse(String.valueOf(result), "", Parser.xmlParser());
    }
}
