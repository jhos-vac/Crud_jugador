package com.example.pruebas.repository

import com.example.pruebas.model.Player
import jakarta.persistence.Id
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PlayerRepository:JpaRepository<Player,Long> {
    fun findById(id:Long?):Player?
}