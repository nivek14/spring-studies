package com.example.calculadora.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OperationsService {

    private DataProcessingService data;

    public Double sum(String numOne, String numTwo) throws Exception {
        return data.convertToDouble(numOne) + data.convertToDouble(numTwo);
    }

    public Double sub(String numOne, String numTwo) throws Exception {
        return data.convertToDouble(numOne) - data.convertToDouble(numTwo);
    }

    public Double mult(String numOne, String numTwo) throws Exception {
        return data.convertToDouble(numOne) * data.convertToDouble(numTwo);
    }

    public Double div(String numOne, String numTwo) throws Exception {
        if(Double.parseDouble(numTwo) == 0) throw new Exception();
        return data.convertToDouble(numOne) / data.convertToDouble(numTwo);
    }

    public Double mean(String numOne, String numTwo) throws Exception {
        return (data.convertToDouble(numOne) + data.convertToDouble(numTwo)) / 2;
    }

    public Double sqrt(String num) throws Exception {
        return Math.sqrt(data.convertToDouble(num));
    }

}
