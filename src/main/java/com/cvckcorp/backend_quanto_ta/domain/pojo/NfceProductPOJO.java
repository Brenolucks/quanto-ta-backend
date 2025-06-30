package com.cvckcorp.backend_quanto_ta.domain.pojo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "prod")
public class NfceProductPOJO {
    @JacksonXmlProperty(localName = "cProd")
    public String code;
    @JacksonXmlProperty(localName = "xProd")
    public String name;
    @JacksonXmlProperty(localName = "uCom")
    public String unit;
    @JacksonXmlProperty(localName = "qCom")
    public double amount;
    @JacksonXmlProperty(localName = "vProd")
    public double price;

}
