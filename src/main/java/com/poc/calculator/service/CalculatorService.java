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

    /**
     * Sums two BigDecimal numbers.
     *
     * @param a the first number
     * @param b the second number
     * @return the sum of a and b, or 0 if inputs are null (handled by logic)
     */
    public BigDecimal sum(BigDecimal a, BigDecimal b) {
        BigDecimal result = a != null && b != null ? a.add(b) : BigDecimal.ZERO;
        tracer.trace(result);
        return result;
    }

    /**
     * Subtracts the second BigDecimal number from the first.
     *
     * @param a the minuend
     * @param b the subtrahend
     * @return the result of subtraction, or 0 if inputs are null
     */
    public BigDecimal subtract(BigDecimal a, BigDecimal b) {
        BigDecimal result = a != null && b != null ? a.subtract(b) : BigDecimal.ZERO;
        tracer.trace(result);
        return result;
    }
}
