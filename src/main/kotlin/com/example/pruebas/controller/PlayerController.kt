package com.example.pruebas.controller

import com.example.pruebas.model.Player
import com.example.pruebas.service.PlayerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/player")
class PlayerController {
    @Autowired
    lateinit var  playerService: PlayerService
    @GetMapping
    fun list():List<Player>{
        return playerService.list()
    }

    @PostMapping
    fun save(@RequestBody player: Player):Player?{
        return playerService.save(player)
    }

    @PutMapping
    fun update(@RequestBody player: Player): ResponseEntity<Player> {
        return ResponseEntity(playerService.update(player), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName(@RequestBody player: Player): ResponseEntity<Player> {
        return ResponseEntity(playerService.updateName(player), HttpStatus.OK)
    }
}