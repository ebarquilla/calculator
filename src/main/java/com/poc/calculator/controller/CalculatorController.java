package com.poc.calculator.controller;

import com.poc.calculator.api.MathApi;
import com.poc.calculator.dto.MathRequest;
import com.poc.calculator.dto.MathResponse;
import com.poc.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * REST Controller for Arithmetic Operations.
 * Implements the generated MathApi interface.
 */
@RestController
@RequestMapping("/api/v1")
public class CalculatorController implements MathApi {

    private final CalculatorService calculatorService;

    /**
     * Constructor for dependency injection.
     *
     * @param calculatorService the business logic service
     */
    @Autowired
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    /**
     * Calculates the sum of two numbers.
     *
     * @param request the math request containing operands
     * @return the result of the sum
     */
    @Override
    public ResponseEntity<MathResponse> calculateSum(MathRequest request) {
        BigDecimal result = calculatorService.sum(BigDecimal.valueOf(request.getNumberA()),
                BigDecimal.valueOf(request.getNumberB()));
        MathResponse response = new MathResponse();
        response.setResult(result.doubleValue());
        return ResponseEntity.ok(response);
    }

    /**
     * Calculates the subtraction of two numbers.
     *
     * @param request the math request containing operands
     * @return the result of the subtraction
     */
    @Override
    public ResponseEntity<MathResponse> calculateSubtraction(MathRequest request) {
        BigDecimal result = calculatorService.subtract(BigDecimal.valueOf(request.getNumberA()),
                BigDecimal.valueOf(request.getNumberB()));
        MathResponse response = new MathResponse();
        response.setResult(result.doubleValue());
        return ResponseEntity.ok(response);
    }
}
