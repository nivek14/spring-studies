package com.example.calculadora.controllers;

import com.example.calculadora.services.OperationsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculadora")
@RequiredArgsConstructor
public class CalculadoraController {

    private final OperationsService operations = new OperationsService();

    @GetMapping("/sum/{numOne}/{numTwo}")
    public Double sum(@PathVariable String numOne, @PathVariable String numTwo) throws Exception {
        return operations.sum(numOne,numTwo);
    }

    @GetMapping("/sub/{numOne}/{numTwo}")
    public Double sub(@PathVariable String numOne, @PathVariable String numTwo) throws Exception {
        return operations.sub(numOne,numTwo);
    }

    @GetMapping("/mul/{numOne}/{numTwo}")
    public Double mult(@PathVariable String numOne, @PathVariable String numTwo) throws Exception {
        return operations.mult(numOne,numTwo);
    }

    @GetMapping("/div/{numOne}/{numTwo}")
    public Double div(@PathVariable String numOne, @PathVariable String numTwo) throws Exception {
        return operations.div(numOne,numTwo);
    }

    @GetMapping("/mean/{numOne}/{numTwo}")
    public Double mean(@PathVariable String numOne, @PathVariable String numTwo) throws Exception {
        return operations.mean(numOne,numTwo);
    }

    @GetMapping("/sqt/{num}")
    public Double sqrt(@PathVariable String num) throws Exception {
        return operations.sqrt(num);
    }

}
