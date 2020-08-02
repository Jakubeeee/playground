package com.jakubeeee.playground.mskotlin.algorithm

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
open class AlgorithmController(private val algorithmService: AlgorithmService) {

    // curl http://localhost:8080/algorithm/invokeloop?iterations=1000
    @GetMapping(path = ["algorithm/invokeloop"])
    fun invokeLoop(@RequestParam(value = "iterations", defaultValue = "1000") iterations: Int) = algorithmService.invokeLoop(iterations)


    // curl http://localhost:8080/algorithm/quicksortrandom?amount=20
    @GetMapping(path = ["algorithm/quicksortrandom"])
    fun quickSortRandomInts(@RequestParam(value = "amount", defaultValue = "20") amount: Int) = algorithmService.quickSortRandomInts(amount)


    // curl http://localhost:8080/algorithm/quicksort?ints=1,10,2,9,3,8,4,7,5,6
    @GetMapping(path = ["algorithm/quicksort"])
    fun quickSort(@RequestParam(value = "ints", defaultValue = "1,10,2,9,3,8,4,7,5,6") unsortedInts: IntArray) = algorithmService.quickSortProvidedInts(unsortedInts)

}
