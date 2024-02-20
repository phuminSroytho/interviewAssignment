package com.example.assignment.controller;

import com.example.assignment.constant.SymbolConstant;
import com.example.assignment.model.Response;
import com.example.assignment.service.AppServiceXML;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class AppControllerXML {
    @Autowired
    private AppServiceXML appServiceXML;

    @GetMapping("/add")
    public ResponseEntity<Response> getAdd(
            @RequestParam Integer intA,
            @RequestParam Integer intB
    ) {
        ResponseEntity<Response> result = new ResponseEntity<>(new Response()
                .setResult(appServiceXML.getCalculateByAction(SymbolConstant.ADD, intA, intB)),
                new HttpHeaders(),
                HttpStatus.OK);
        log.info("GET /add with firstParam{}, secondParam {} result is {}", intA, intB, result);
        return result;
    }

    @GetMapping("/divide")
    public ResponseEntity<Response> getDivide(
            @RequestParam Integer intA,
            @RequestParam Integer intB
    ) {
        ResponseEntity<Response> result = new ResponseEntity<>(new Response()
                .setResult(appServiceXML.getCalculateByAction(SymbolConstant.DIVIDE, intA, intB)),
                new HttpHeaders(),
                HttpStatus.OK);
        log.info("GET /divide with firstParam{}, secondParam {} result is {}", intA, intB, result);
        return result;
    }

    @GetMapping("/multiply")
    public ResponseEntity<Response> getMultiply(
            @RequestParam Integer intA,
            @RequestParam Integer intB
    ) {
        ResponseEntity<Response> result = new ResponseEntity<>(new Response()
                .setResult(appServiceXML.getCalculateByAction(SymbolConstant.MULTIPLY, intA, intB)),
                new HttpHeaders(),
                HttpStatus.OK);
        log.info("GET /multiply with firstParam{}, secondParam {} result is {}", intA, intB, result);
        return result;
    }

    @GetMapping("/subtract")
    public ResponseEntity<Response> getSubtract(
            @RequestParam Integer intA,
            @RequestParam Integer intB
    ) {
        ResponseEntity<Response> result = new ResponseEntity<>(new Response()
                .setResult(appServiceXML.getCalculateByAction(SymbolConstant.SUBTRACT, intA, intB)),
                new HttpHeaders(),
                HttpStatus.OK);
        log.info("GET /subtract with firstParam{}, secondParam {} result is {}", intA, intB, result);
        return result;
    }
}
