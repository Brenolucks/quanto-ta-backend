package com.cvckcorp.backend_quanto_ta.domain.pojo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "enderEmit")
public class AddressCompanyPOJO {
    @JacksonXmlProperty(localName = "xLgr")
    public String address;
    @JacksonXmlProperty(localName = "nro")
    public int number;
}
