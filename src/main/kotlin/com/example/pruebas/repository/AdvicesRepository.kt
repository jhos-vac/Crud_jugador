package com.example.pruebas.repository

import com.example.pruebas.model.Advices
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AdvicesRepository:JpaRepository <Advices, Long> {
    fun findById(id:Long?):Advices?
}