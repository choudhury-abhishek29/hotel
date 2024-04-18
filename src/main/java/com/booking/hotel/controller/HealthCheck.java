package com.booking.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class HealthCheck {
    @Autowired
    Environment environment;

    @Autowired
    private ServletWebServerApplicationContext webServerAppCtxt;

    @GetMapping(path="/ping")
    public String healthCheck() throws UnknownHostException {
        String address = InetAddress.getLocalHost().getHostAddress()+":"+webServerAppCtxt.getWebServer().getPort();
        return "Application is running on "+address;
    }
}
