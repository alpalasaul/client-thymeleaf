package com.programacion.config;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import org.springframework.web.client.RestTemplate;

@ApplicationScoped
public class Config {

    @Produces
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


}
