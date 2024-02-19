package com.example.assignment.service;

import com.example.assignment.constant.SymbolConstant;
import com.example.assignment.util.Util;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.Objects;

import static com.example.assignment.constant.CommonConstant.APPLICATION_CONTENT_TYPE_SOAP_XML;

@Service
@Slf4j
public class AppServiceXML {
    private final String calculatorUrl = "http://www.dneonline.com/calculator.asmx";
    private final RestTemplate restTemplate = new RestTemplate();

    @SneakyThrows
    public Integer getCalculateByAction(SymbolConstant action,Integer intA,Integer intB){
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(calculatorUrl);
        HttpHeaders newHttpHeader = new HttpHeaders();
        newHttpHeader.setContentType(MediaType.valueOf(APPLICATION_CONTENT_TYPE_SOAP_XML));
        newHttpHeader.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));

        HttpEntity<String> httpEntity = new HttpEntity<>(Util.generateAddSoapXMLRequest(action.getRequest(), intA, intB), newHttpHeader);

        log.info("Calling E-API with url: {} \n" +
                "HttpEntity: {}", builder.build().toUriString(), httpEntity);
        String soapResponse = restTemplate.postForObject(
                builder.build().toUriString(),
                httpEntity,
                String.class);

        if (Objects.isNull(soapResponse)) {
            log.error("Got empty result when calling {} with {}", calculatorUrl,action.getRequest());
            throw new Exception();
        }
        return Integer.valueOf(Objects.requireNonNull(Util.getResponseSoapXML(soapResponse, action.getResponse())));
    }
}
