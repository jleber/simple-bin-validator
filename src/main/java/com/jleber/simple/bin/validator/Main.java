package com.jleber.simple.bin.validator;

import com.jleber.simple.bin.validator.config.ApiConfig;
import org.springframework.boot.SpringApplication;

/**
 * Created by jleber on 06/06/16.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ApiConfig.class, args);
    }
}
