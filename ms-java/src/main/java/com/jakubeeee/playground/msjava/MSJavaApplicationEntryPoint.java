package com.jakubeeee.playground.msjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.jakubeeee.playground.msjava.MSJavaApplicationConstants.ROOT_PACKAGE;

@SpringBootApplication(scanBasePackages = ROOT_PACKAGE)
public class MSJavaApplicationEntryPoint {

    public static void main(String[] args) {
        SpringApplication.run(MSJavaApplicationEntryPoint.class, args);
    }

}
