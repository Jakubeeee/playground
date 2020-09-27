package com.jakubeeee.playground.client;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

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
        msJavaClient.getAsync("algorithm/invokeloop?iterations=300");
        msKotlinClient.getAsync("algorithm/invokeloop?iterations=300");

        msJavaClient.getAsync("algorithm/quicksortrandom?amount=50");
        msKotlinClient.getAsync("algorithm/quicksortrandom?amount=50");

        msJavaClient.getAsync("algorithm/quicksort?ints=46,75,23,64,77,32,12,3,56,43,1,64,73,35,37,84,33,45,19,71,90,42");
        msKotlinClient.getAsync("algorithm/quicksort?ints=46,75,23,64,77,32,12,3,56,43,1,64,73,35,37,84,33,45,19,71,90,42");

        msJavaClient.getAsync("count?type=WORKER&position=SENIOR");
        msKotlinClient.getAsync("count?type=WORKER&position=SENIOR");

        msJavaClient.getAsync("count?type=MANAGER&position=REGULAR&departmentName=Marketing");
        msKotlinClient.getAsync("count?type=MANAGER&position=REGULAR&departmentName=Marketing");

        msJavaClient.getAsync("cost?type=WORKER&position=REGULAR&managerName=ManagerIT");
        msKotlinClient.getAsync("cost?type=WORKER&position=REGULAR&managerName=ManagerIT");

        msJavaClient.getAsync("cost?type=WORKER&position=REGULAR&departmentName=Information_Technologies&managerName=ManagerIT");
        msKotlinClient.getAsync("cost?type=WORKER&position=REGULAR&departmentName=Information_Technologies&managerName=ManagerIT");
    }

}
