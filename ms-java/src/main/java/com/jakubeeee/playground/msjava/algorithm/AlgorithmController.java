package com.jakubeeee.playground.msjava.algorithm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlgorithmController {

    private final AlgorithmService algorithmService;

    @Autowired
    public AlgorithmController(AlgorithmService algorithmService) {
        this.algorithmService = algorithmService;
    }

    // curl http://localhost:8080/algorithm/invokeloop?iterations=1000
    @GetMapping(path = "algorithm/invokeloop")
    public int invokeLoop(@RequestParam(value = "iterations", defaultValue = "1000") int iterations) {
        return algorithmService.invokeLoop(iterations);
    }

    // curl http://localhost:8080/algorithm/quicksortrandom?amount=20
    @GetMapping(path = "algorithm/quicksortrandom")
    public int[] quickSortRandomInts(@RequestParam(value = "amount", defaultValue = "20") int amount) {
        return algorithmService.quickSortRandomInts(amount);
    }

    // curl http://localhost:8080/algorithm/quicksort?ints=1,10,2,9,3,8,4,7,5,6
    @GetMapping(path = "algorithm/quicksort")
    public int[] quickSort(@RequestParam(value = "ints", defaultValue = "1,10,2,9,3,8,4,7,5,6") int[] unsortedInts) {
        return algorithmService.quickSortProvidedInts(unsortedInts);
    }

}
