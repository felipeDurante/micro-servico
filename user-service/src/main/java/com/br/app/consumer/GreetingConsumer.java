package com.br.app.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class GreetingConsumer {

    private final RestTemplate restTemplate;

    @Value("${app.employeeSearch.serviceId}")
    private String greetingServiceId;

    @Value("${app.employeeSearch.endpoint.greeting}")
    private String greetingEndpointUri;

    @Autowired
    public GreetingConsumer(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "getDefaultGreeting")
    public String getRandomGreeting() {
        String greeting = restTemplate.getForObject("http://greeting-service" + greetingEndpointUri, String.class);
        return greeting;
    }

    public String getDefaultGreeting() {
        return "Good bye";
    }
}
