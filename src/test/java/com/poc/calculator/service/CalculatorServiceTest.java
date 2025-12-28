package com.poc.calculator.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.math.BigDecimal;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CalculatorServiceTest {

    @Mock
    private io.corp.calculator.TracerImpl tracer;

    @InjectMocks
    private CalculatorService calculatorService;

    @Test
    void sumar_shouldReturnCorrectSum() {
        BigDecimal a = new BigDecimal("10");
        BigDecimal b = new BigDecimal("20");
        BigDecimal result = calculatorService.sum(a, b);
        assertEquals(new BigDecimal("30"), result);
        verify(tracer).trace(result);
    }

    @Test
    void restar_shouldReturnCorrectSubtraction() {
        BigDecimal a = new BigDecimal("20");
        BigDecimal b = new BigDecimal("10");
        BigDecimal result = calculatorService.subtract(a, b);
        assertEquals(new BigDecimal("10"), result);
        verify(tracer).trace(result);
    }
}
