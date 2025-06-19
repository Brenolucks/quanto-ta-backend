package com.cvckcorp.backend_quanto_ta.service.product;

import com.cvckcorp.backend_quanto_ta.domain.dto.NfceProductResponseDto;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public List<NfceProductResponseDto> getProductFields(Document document) {
        List<NfceProductResponseDto> product = new ArrayList<>();

        for(Element e : document.getElementsByTag("det")) {
            var products = new NfceProductResponseDto(e.getElementsByTag("cProd").text(), e.getElementsByTag("xProd").text(),
                    e.getElementsByTag("uCom").text(), e.getElementsByTag("qCom").text(),
                    e.getElementsByTag("vProd").text());
            product.add(products);
        }

        return product;
    }
}
