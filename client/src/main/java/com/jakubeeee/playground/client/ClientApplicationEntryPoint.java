package com.jakubeeee.playground.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.jakubeeee.playground.client.ClientApplicationConstants.ROOT_PACKAGE;

@SpringBootApplication(scanBasePackages = ROOT_PACKAGE)
public class ClientApplicationEntryPoint {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplicationEntryPoint.class, args);
    }

}
