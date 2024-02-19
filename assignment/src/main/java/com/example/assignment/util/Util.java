package com.example.assignment.util;

import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;

import static com.example.assignment.constant.CommonConstant.CALCULATOR_SOAP_XML_FORMAT;

@Slf4j
public class Util {
    public static String generateAddSoapXMLRequest(String action, Integer intA, Integer intB) {
        return String.format(CALCULATOR_SOAP_XML_FORMAT
                , action, intA, intB, action);
    }

    public static String getResponseSoapXML(String xml, String action) {
        try {
            // Create a DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the SOAP XML response
            Document document = builder.parse(new InputSource(new StringReader(xml)));

            // Get the value of the AddResult element
            NodeList nodeList = document.getElementsByTagName(action);
            if (nodeList.getLength() > 0) {
                Element element = (Element) nodeList.item(0);
                return element.getTextContent();
            } else {
                log.error(action + " element not found in the SOAP response.");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
