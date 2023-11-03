package com.santoshkumar.currencyconversionservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionController {

    @Autowired
    private Environment environment;

    @GetMapping("/currency-conversion/from/{codeFrom}/to/{codeTo}/quantity/{quantity}")
    public CurrencyConversion retrieveCurrencyConversion(
            @PathVariable String codeFrom,
            @PathVariable String codeTo,
            @PathVariable BigDecimal quantity
    ) {
        return new CurrencyConversion(1001L, codeFrom, codeTo, new BigDecimal(65),
                environment.getProperty("spring.application.name"), quantity, quantity.multiply(new BigDecimal(65)));
    }
}
