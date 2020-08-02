package com.jakubeeee.playground.client;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

@Slf4j
public class ClientApplicationEntryPoint {

    private static final MSClient msJavaClient = new MSJavaClient();
    private static final MSClient msKotlinClient = new MSKotlinClient();

    public static void main(String[] args) {
        gatherInput();
    }

    static void gatherInput() {
        try (var scanner = new Scanner(in)) {
            out.println("Type \"RUN\" or \"EXIT\"");
            var input = scanner.next();
            if (input.equalsIgnoreCase("EXIT"))
                Runtime.getRuntime().exit(0);
            else if (input.equalsIgnoreCase("RUN")) {
                runTest();
                gatherInput();
            } else
                gatherInput();
        }
    }

    static void runTest() {
        msJavaClient.getAsync("algorithm/quicksortrandom?amount=100");
        msKotlinClient.getAsync("algorithm/quicksortrandom?amount=100");
    }

}
