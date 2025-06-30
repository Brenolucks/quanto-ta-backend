package com.cvckcorp.backend_quanto_ta.domain.pojo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "emit")
public class NfceCompanyPOJO {
    @JacksonXmlProperty(localName = "CNPJ")
    public String cnpj;
    @JacksonXmlProperty(localName = "xNome")
    public String name;
    @JacksonXmlProperty(localName = "xFant")
    public String fant;
    @JacksonXmlProperty(localName = "enderEmit")
    public AddressCompanyPOJO address;
}
