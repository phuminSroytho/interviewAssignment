package com.example.assignment.service;

import com.example.assignment.constant.SymbolConstant;
import com.example.assignment.util.Util;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class AppServiceXMLTest {
    @InjectMocks
    private AppServiceXML appServiceXML;



    RestTemplate restTemplateMock = Mockito.mock(RestTemplate.class);

    private final String url = "http://www.dneonline.com/calculator.asmx";

    @BeforeEach
    void setup() {
        ReflectionTestUtils.setField(appServiceXML, "calculatorUrl", url);
        ReflectionTestUtils.setField(appServiceXML, "restTemplate", restTemplateMock);
    }

    @Test
    void test_getCalculateByAction_failed() {
        doReturn(null)
                .when(restTemplateMock)
                .postForObject(anyString(),
                        any(),
                        eq(String.class));

        Exception actual = assertThrows(Exception.class, () -> appServiceXML.getCalculateByAction(SymbolConstant.ADD, 20, 10));
        assertEquals(Exception.class, actual.getClass());
    }

    @Test
    void test_getCalculateByAction_success() {
        doReturn("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <AddResponse xmlns=\"http://tempuri.org/\">\n" +
                "      <AddResult>30</AddResult>\n" +
                "    </AddResponse>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>")
                .when(restTemplateMock)
                .postForObject(anyString(),
                        any(),
                        eq(String.class));

        assertDoesNotThrow(() -> appServiceXML.getCalculateByAction(SymbolConstant.ADD, 20, 10));
    }
}