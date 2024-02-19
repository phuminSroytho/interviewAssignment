package com.example.assignment.constant;

import lombok.Getter;

@Getter
public enum SymbolConstant {
    ADD("Add", "AddResult"),
    DIVIDE("Divide", "DivideResult"),
    SUBTRACT("Subtract", "SubtractResult"),
    MULTIPLY("Multiply", "MultiplyResult");

    public final String request;
    public final String response;

    SymbolConstant(String request, String response) {
        this.request = request;
        this.response = response;
    }
}
