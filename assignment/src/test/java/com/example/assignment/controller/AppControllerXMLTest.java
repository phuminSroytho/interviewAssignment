package com.example.assignment.controller;

import com.example.assignment.service.AppServiceXML;
import com.example.assignment.constant.SymbolConstant;
import com.example.assignment.model.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class AppControllerXMLTest {
    @InjectMocks
    private AppControllerXML appControllerXML;
    @Mock
    private AppServiceXML appServiceXML;

    private final Integer intA = 20;
    private final Integer intB = 10;

    private ResponseEntity<Response> response = new ResponseEntity<Response>(new Response(),
            new HttpHeaders(),
            HttpStatus.OK);

    @Test
    void test_getAdd_success() {
        doReturn(30)
                .when(appServiceXML)
                .getCalculateByAction(SymbolConstant.ADD, intA, intB);

        var actual = appControllerXML.getAdd(intA, intB);
        assertEquals(response.getBody().setResult(30), actual.getBody());
    }

    @Test
    void test_getMultiply_success() {
        doReturn(200)
                .when(appServiceXML)
                .getCalculateByAction(SymbolConstant.MULTIPLY, intA, intB);

        var actual = appControllerXML.getMultiply(intA, intB);
        assertEquals(response.getBody().setResult(200), actual.getBody());
    }

    @Test
    void test_getDivide_success() {
        doReturn(2)
                .when(appServiceXML)
                .getCalculateByAction(SymbolConstant.DIVIDE, intA, intB);

        var actual = appControllerXML.getDivide(intA, intB);
        assertEquals(response.getBody().setResult(2), actual.getBody());
    }

    @Test
    void test_getSubtract_success() {
        doReturn(10)
                .when(appServiceXML)
                .getCalculateByAction(SymbolConstant.SUBTRACT, intA, intB);

        var actual = appControllerXML.getSubtract(intA, intB);
        assertEquals(response.getBody().setResult(10), actual.getBody());
    }
}