package com.jleber.simple.bin.validator.controller;

import com.jleber.simple.bin.validator.model.CreditCardInfo;
import com.jleber.simple.bin.validator.service.BinValidatorService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jleber on 06/06/16.
 */
@RestController
public class BinValidatorController {

    @Autowired
    private BinValidatorService service;

    @RequestMapping(value = "/bin/check/{number}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<CreditCardInfo> checkBin(@PathVariable String number) {
        if (StringUtils.isBlank(number)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(service.solveBin(number), HttpStatus.OK);
    }
}
