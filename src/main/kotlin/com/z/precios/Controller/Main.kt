package com.z.precios.Controller

import com.z.precios.Service.ExcelService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class Main(val excelService: ExcelService) {
    @GetMapping("/") fun index() = excelService.findAll()
    @GetMapping("/byName/{name}") fun findByName(@PathVariable("name") name:String) = excelService.findByName(name)
    @GetMapping("/{id}") fun findById(@PathVariable("id") id:String) = excelService.findById(id)
}