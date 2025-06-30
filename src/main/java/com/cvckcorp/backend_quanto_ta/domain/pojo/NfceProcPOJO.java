package com.cvckcorp.backend_quanto_ta.domain.pojo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "proc")
public class NfceProcPOJO {
    @JacksonXmlProperty(localName = "nfeProc")
    public NfceNfeProcInnerPOJO nfeProc;
}
