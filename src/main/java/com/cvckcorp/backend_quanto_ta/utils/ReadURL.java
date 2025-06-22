package com.cvckcorp.backend_quanto_ta.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ReadURL {
    public Document ReadUrlFromLink(String defaultURL) {
        RestTemplate restTemplate = new RestTemplate();
        var newURL = "";

        if(defaultURL.startsWith("http:")) newURL = defaultURL.replace("http", "https");
        var URL = newURL.isEmpty() ? defaultURL : newURL;

        ResponseEntity<String> xml = restTemplate.getForEntity(URL, String.class);

        return Jsoup.parse(String.valueOf(xml), "", Parser.xmlParser());
    }
}
