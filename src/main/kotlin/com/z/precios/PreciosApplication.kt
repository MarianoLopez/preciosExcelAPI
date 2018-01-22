package com.z.precios

import com.z.precios.Util.NetworkUtils.getLocalIpAddress
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class PreciosApplication

fun main(args: Array<String>) {
    SpringApplication.run(PreciosApplication::class.java, *args)
    println(getLocalIpAddress())
}


