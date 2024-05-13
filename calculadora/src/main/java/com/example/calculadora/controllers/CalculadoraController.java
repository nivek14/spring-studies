package com.example.calculadora.controllers;

import com.example.calculadora.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

    @GetMapping("/sum/{numOne}/{numTwo}")
    public Double sum(@PathVariable String numOne, @PathVariable String numTwo) throws Exception {
        return convertToDouble(numOne) + convertToDouble(numTwo);
    }

    @GetMapping("/sub/{numOne}/{numTwo}")
    public Double sub(@PathVariable String numOne, @PathVariable String numTwo) throws Exception {
        return convertToDouble(numOne) - convertToDouble(numTwo);
    }

    @GetMapping("/mul/{numOne}/{numTwo}")
    public Double mul(@PathVariable String numOne, @PathVariable String numTwo) throws Exception {
        return convertToDouble(numOne) * convertToDouble(numTwo);
    }

    @GetMapping("/div/{numOne}/{numTwo}")
    public Double div(@PathVariable String numOne, @PathVariable String numTwo) throws Exception {
        if(Double.parseDouble(numTwo) == 0) throw new Exception();
        return convertToDouble(numOne) / convertToDouble(numTwo);
    }

    @GetMapping("/avr/{numOne}/{numTwo}")
    public Double avr(@PathVariable String numOne, @PathVariable String numTwo) throws Exception {
        return (convertToDouble(numOne) + convertToDouble(numTwo)) / 2;
    }

    @GetMapping("/sqt/{num}")
    public Double sqt(@PathVariable String num) throws Exception {
        return Math.sqrt(convertToDouble(num));
    }

    private Double convertToDouble(String strNumber) throws Exception {

        if(strNumber == null) throw new Exception();

        String number = strNumber.replaceAll(",", ".");

        if(!isNumeric(number)){
            throw new UnsupportedMathOperationException("Set numeric value");
        }

        return Double.parseDouble(strNumber);
    }

    private boolean isNumeric(String strNumber) {

        if(strNumber == null) return false;

        try{
            Double.parseDouble(strNumber);
        }catch (NumberFormatException exception){
            return false;
        }

        return true;
    }


}
