package com.cvckcorp.backend_quanto_ta.domain.pojo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "NFe")
public class NfceNFePOJO {
    @JacksonXmlProperty(localName = "infNFe")
    public NfceInfNFePOJO infNFe;
}
