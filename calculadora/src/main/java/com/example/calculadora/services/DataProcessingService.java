package com.example.calculadora.services;

import com.example.calculadora.exceptions.UnsupportedMathOperationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DataProcessingService {

    public static Double convertToDouble(String strNumber) throws Exception {

        if(strNumber == null) throw new Exception();

        String number = strNumber.replaceAll(",", ".");

        if(!isNumeric(number)){
            throw new UnsupportedMathOperationException("Set numeric value");
        }

        return Double.parseDouble(strNumber);
    }

    public static boolean isNumeric(String strNumber) {

        if(strNumber == null) return false;

        try{
            Double.parseDouble(strNumber);
        }catch (NumberFormatException exception){
            return false;
        }

        return true;
    }

}
