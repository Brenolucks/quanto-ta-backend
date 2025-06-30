package com.cvckcorp.backend_quanto_ta.domain.pojo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "det")
public class NfceDetPOJO {
    @JacksonXmlProperty(localName = "nItem", isAttribute = true)
    public String nItem;
    @JacksonXmlProperty(localName = "prod")
    public NfceProductPOJO prod;
}
