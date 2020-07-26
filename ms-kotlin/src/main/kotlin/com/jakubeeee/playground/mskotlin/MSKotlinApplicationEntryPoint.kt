package com.jakubeeee.playground.mskotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = [ROOT_PACKAGE])
open class MSKotlinApplicationEntryPoint

fun main(args: Array<String>) {
    runApplication<MSKotlinApplicationEntryPoint>(*args)
}
