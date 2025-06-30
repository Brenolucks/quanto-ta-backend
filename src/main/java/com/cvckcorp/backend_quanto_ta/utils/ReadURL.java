package com.cvckcorp.backend_quanto_ta.utils;

import com.cvckcorp.backend_quanto_ta.domain.pojo.NfceNfeProcPOJO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class ReadURL {
    public NfceNfeProcPOJO ReadUrlFromLink(String defaultURL) {
        String newURL = "";
        if(defaultURL.startsWith("http:")) newURL = defaultURL.replace("http", "https");
        var URL = newURL.isEmpty() ? defaultURL : newURL;

        return RestClient.create().get().uri(URL).retrieve().body(NfceNfeProcPOJO.class);
    }
}
