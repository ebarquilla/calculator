package com.poc.calculator.service;

import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class CalculatorService {

    public BigDecimal sum(BigDecimal a, BigDecimal b) {
        return a != null && b != null ? a.add(b) : BigDecimal.ZERO;
    }

    public BigDecimal subtract(BigDecimal a, BigDecimal b) {
        return a != null && b != null ? a.subtract(b) : BigDecimal.ZERO;
    }
}
