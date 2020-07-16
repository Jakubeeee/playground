package com.jakubeeee.playground.msjava.algorithm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlgorithmController {

    private final AlgorithmService algorithmService;

    @Autowired
    public AlgorithmController(AlgorithmService algorithmService) {
        this.algorithmService = algorithmService;
    }

    // curl -X POST -d "iterations=1000" http://localhost:8080/algorithm/invokeloop
    @PostMapping(path = "algorithm/invokeloop")
    public void invokeLoop(@RequestParam(value = "iterations", defaultValue = "1000") int iterations) {
        algorithmService.invokeLoop(iterations);
    }

    // curl -X POST -d "amount=20" http://localhost:8080/algorithm/quicksortrandom
    @PostMapping(path = "algorithm/quicksortrandom")
    public void quickSortRandomInts(@RequestParam(value = "amount", defaultValue = "20") int amount) {
        algorithmService.quickSortRandomInts(amount);
    }

    // curl -X POST -d "ints=1,10,2,9,3,8,4,7,5,6" http://localhost:8080/algorithm/quicksort
    @PostMapping(path = "algorithm/quicksort")
    public void quickSort(@RequestParam(value = "ints", defaultValue = "1,10,2,9,3,8,4,7,5,6") int[] unsortedInts) {
        algorithmService.quickSortProvidedInts(unsortedInts);
    }

}
