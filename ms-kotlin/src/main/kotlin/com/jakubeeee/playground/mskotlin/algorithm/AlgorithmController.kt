package com.jakubeeee.playground.mskotlin.algorithm

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
open class AlgorithmController(private val algorithmService: AlgorithmService) {

    // curl -X POST -d "iterations=1000" http://localhost:8080/algorithm/invokeloop
    @PostMapping(path = ["algorithm/invokeloop"])
    fun invokeLoop(@RequestParam(value = "iterations") iterations: Int = 1000) {
        algorithmService.invokeLoop(iterations)
    }

    // curl -X POST -d "amount=20" http://localhost:8080/algorithm/quicksortrandom
    @PostMapping(path = ["algorithm/quicksortrandom"])
    fun quickSortRandomInts(@RequestParam(value = "amount") amount: Int = 20) {
        algorithmService.quickSortRandomInts(amount)
    }

    // curl -X POST -d "ints=1,10,2,9,3,8,4,7,5,6" http://localhost:8080/algorithm/quicksort
    @PostMapping(path = ["algorithm/quicksort"])
    fun quickSort(@RequestParam(value = "ints") unsortedInts: IntArray = intArrayOf(1, 10, 2, 9, 3, 8, 4, 7, 5, 6)) {
        algorithmService.quickSortProvidedInts(unsortedInts)
    }

}
