package com.cvckcorp.backend_quanto_ta.service.product;

import com.cvckcorp.backend_quanto_ta.domain.dto.NfceProductRequestDto;
import com.cvckcorp.backend_quanto_ta.domain.dto.NfceProductResponseDto;
import com.cvckcorp.backend_quanto_ta.domain.mappers.ProductMapper;
import com.cvckcorp.backend_quanto_ta.domain.model.Product;
import com.cvckcorp.backend_quanto_ta.domain.pojo.NfceDetPOJO;
import com.cvckcorp.backend_quanto_ta.domain.pojo.NfceNfeProcPOJO;
import com.cvckcorp.backend_quanto_ta.repositories.CompanyRepository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository,
                              ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public List<NfceProductResponseDto> getProductFields(NfceNfeProcPOJO document) {
        List<NfceProductResponseDto> product = new ArrayList<>();

        for(NfceDetPOJO itens : document.proc.nfeProc.NFe.infNFe.det) {
            var products = new NfceProductResponseDto(
                    itens.prod.code,
                    itens.prod.name,
                    itens.prod.unit,
                    itens.prod.amount,
                    itens.prod.price);
            product.add(products);
        }

        return product;
    }

    @Override
    public String saveProducts(List<NfceProductRequestDto> nfceProductRequestDto, long comapnyID) {
        List<Product> products = nfceProductRequestDto.stream().map(
                prod -> productMapper.toEntityWithCompanyID(prod, comapnyID))
                .toList();
        productRepository.saveAll(products);
        return products.size() + "produtos cadastrados";
    }
}
