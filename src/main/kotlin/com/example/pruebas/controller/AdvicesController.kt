package com.example.pruebas.controller

import com.example.pruebas.model.Advices
import com.example.pruebas.service.AdvicesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/advices")
class AdvicesController {
    @Autowired
    lateinit var  advicesService: AdvicesService
    @GetMapping
    fun list():List<Advices>{
        return advicesService.list()
    }

    @PostMapping
    fun save(@RequestBody advices: Advices):Advices?{
        return advicesService.save(advices)
    }

    @PutMapping
    fun update(@RequestBody advices: Advices): ResponseEntity<Advices> {
        return ResponseEntity(advicesService.update(advices), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName(@RequestBody advices: Advices): ResponseEntity<Advices> {
        return ResponseEntity(advicesService.updateName(advices), HttpStatus.OK)
    }
}