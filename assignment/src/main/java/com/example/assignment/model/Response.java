package com.example.assignment.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Response {
    public Integer result;
}
