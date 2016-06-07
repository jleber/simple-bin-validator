package com.jleber.simple.bin.validator.service;

import com.jleber.simple.bin.validator.model.CreditCardInfo;

/**
 * Created by jleber on 06/06/16.
 */
public interface BinValidatorService {
    CreditCardInfo solveBin(String number);
}
