package com.example.pruebas.service

import com.example.pruebas.model.Player
import com.example.pruebas.repository.PlayerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class PlayerService {
    @Autowired
    lateinit var playerRepository:PlayerRepository

    fun list() :List<Player>{
        return  playerRepository.findAll()
    }

    fun save(player: Player):Player{
        return playerRepository.save(player)
    }

    fun update(player: Player):Player{
        try {
            playerRepository.findById(player.id)
                ?: throw Exception("ID no existe")

            return playerRepository.save(player)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }


    }

    fun updateName(player: Player):Player{
        try {
            val response= playerRepository.findById(player.id)
                ?: throw Exception("ID no existe")
            response.apply {
                fullname= player.fullname
            }
            return playerRepository.save(response)
        }
        catch (ex:Exception){
            throw  ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

}