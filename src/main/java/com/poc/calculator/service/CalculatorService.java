package com.poc.calculator.service;

import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class CalculatorService {

    private final io.corp.calculator.TracerImpl tracer;

    /**
     * Constructor for dependency injection.
     *
     * @param tracer the tracer implementation to use for logging results
     */
    public CalculatorService(io.corp.calculator.TracerImpl tracer) {
        this.tracer = tracer;
    }

    public BigDecimal sum(BigDecimal a, BigDecimal b) {
        BigDecimal result = a != null && b != null ? a.add(b) : BigDecimal.ZERO;
        tracer.trace(result);
        return result;
    }

    public BigDecimal subtract(BigDecimal a, BigDecimal b) {
        BigDecimal result = a != null && b != null ? a.subtract(b) : BigDecimal.ZERO;
        tracer.trace(result);
        return result;
    }
}
