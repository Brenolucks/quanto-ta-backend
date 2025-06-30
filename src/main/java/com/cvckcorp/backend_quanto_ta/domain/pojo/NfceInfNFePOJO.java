package com.cvckcorp.backend_quanto_ta.domain.pojo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "infNFe")
public class NfceInfNFePOJO {
    @JacksonXmlProperty(localName = "emit")
    public NfceCompanyPOJO company;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "det")
    public List<NfceDetPOJO> det;
}
