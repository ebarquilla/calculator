package com.poc.calculator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for the Tracer library.
 */
@Configuration
public class TracerConfiguration {

    /**
     * Creates a bean for the TracerImpl class.
     * This bean is used to trace the results of the operations.
     *
     * @return the TracerImpl instance
     */
    @Bean
    public io.corp.calculator.TracerImpl tracer() {
        return new io.corp.calculator.TracerImpl();
    }
}
