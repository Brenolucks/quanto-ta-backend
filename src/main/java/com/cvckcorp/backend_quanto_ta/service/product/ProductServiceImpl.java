package com.cvckcorp.backend_quanto_ta.service.product;

import com.cvckcorp.backend_quanto_ta.domain.dto.NfceProductRequestDto;
import com.cvckcorp.backend_quanto_ta.domain.dto.NfceProductResponseDto;
import com.cvckcorp.backend_quanto_ta.domain.dto.NfceRequestDto;
import com.cvckcorp.backend_quanto_ta.domain.model.Company;
import com.cvckcorp.backend_quanto_ta.domain.model.Product;
import com.cvckcorp.backend_quanto_ta.repositories.CompanyRepository.ProductRepository;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

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

    public String saveProducts(List<NfceProductRequestDto> nfceProductRequestDto, long company) {
        List<Product> products = nfceProductRequestDto.stream().map(prod -> {
            var product = new Product();
            product.setName(prod.name());
            product.setCode(prod.code());
            product.setAmount(Double.parseDouble(prod.amount()));
            product.setPrice(Double.parseDouble(prod.price()));
            product.setUnit(prod.unit());
            Company c = new Company();
            c.setId(company);
            product.setCompany(c);
            return product;
        }).toList();
        productRepository.saveAll(products);
        return products.size() + "produtos cadastrados";
    }
}
