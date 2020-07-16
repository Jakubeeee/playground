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

    @PostMapping(path = "algorithm/invokeloop")
    public void invokeLoop(@RequestParam(value = "iterations", defaultValue = "1000") int iterations) {
        algorithmService.invokeLoop(iterations);
    }

}
