package com.example.assignment.constant;

public class CommonConstant {
    public static final String APPLICATION_CONTENT_TYPE_SOAP_XML = "application/soap+xml";
    public static final String CALCULATOR_SOAP_XML_FORMAT = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
            "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
            "  <soap12:Body>\n" +
            "    <%s xmlns=\"http://tempuri.org/\">\n" +
            "      <intA>%d</intA>\n" +
            "      <intB>%d</intB>\n" +
            "    </%s>\n" +
            "  </soap12:Body>\n" +
            "</soap12:Envelope>";
}
