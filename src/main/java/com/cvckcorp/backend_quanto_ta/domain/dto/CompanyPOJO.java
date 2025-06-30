package com.cvckcorp.backend_quanto_ta.domain.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JacksonXmlRootElement(localName = "emit")
public class CompanyPOJO {
    @JacksonXmlProperty(localName = "CNPJ")
    public String cnpj;
    @JacksonXmlProperty(localName = "xNome")
    public String name;
}
