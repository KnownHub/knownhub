package com.knownhub.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author eagel
 * @since 0.0.1
 */
@SpringBootApplication
@RestController
public class KnownHubService {
    public static final String SERVICE_PREFIX = "service/";

    public static void main(String[] args) {
        SpringApplication.run(KnownHubService.class, args);
    }

    @RequestMapping(SERVICE_PREFIX + "index")
    public String index() {
        return "KnownHub";
    }
}
