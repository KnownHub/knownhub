package com.knownhub.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author eagel
 * @since 0.0.1
 */
@SpringBootApplication
@RestController
public class KnownHubService implements ErrorController {
    public static final String SERVICE_PREFIX = "/service/";

    public static void main(String[] args) {
        SpringApplication.run(KnownHubService.class, args);
    }

    @RequestMapping(SERVICE_PREFIX + "index")
    public String index() {
        return "KnownHub";
    }

    @RequestMapping("/error")
    @ResponseBody
    public ResponseEntity<Message> error(HttpServletRequest request, Throwable ex) {
        HttpStatus status = getStatus(request);
        return new ResponseEntity<>(new Message(status.value(), ex.getMessage()), status);
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

    public static class Message {
        private int status;
        private String message;

        public Message(int status, String message) {
            this.status = status;
            this.message = message;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
}
