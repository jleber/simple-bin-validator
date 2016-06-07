package com.jleber.simple.bin.validator.service;

import com.jleber.simple.bin.validator.enumeration.Bin;
import com.jleber.simple.bin.validator.model.CreditCardInfo;
import org.springframework.stereotype.Service;

/**
 * Created by jleber on 06/06/16.
 */
@Service
public class BinValidatorServiceImpl implements BinValidatorService {

    @Override
    public CreditCardInfo solveBin(String number) {
        number = number.substring(0,6);
        CreditCardInfo creditCardInfo = Bin.get(number);
        creditCardInfo = solveWithTwoDigits(creditCardInfo, number);
        creditCardInfo = solveWithOneDigit(creditCardInfo, number);

        return creditCardInfo;
    }

    private CreditCardInfo solveWithTwoDigits(CreditCardInfo creditCardInfo, String number){
        if(creditCardInfo == null){
            return Bin.get(number.substring(0,2));
        }

        return creditCardInfo;
    }

    private CreditCardInfo solveWithOneDigit(CreditCardInfo creditCardInfo, String number){
        if(creditCardInfo == null){
            return Bin.get(number.substring(0,1));
        }

        return creditCardInfo;
    }
}
