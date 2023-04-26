package com.example.pruebas.service

import com.example.pruebas.model.Advices
import com.example.pruebas.repository.AdvicesRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class AdvicesService {
    @Autowired
    lateinit var advicesRepository: AdvicesRepository

    fun list() :List<Advices>{
        return  advicesRepository.findAll()
    }

    fun save(advices: Advices):Advices{
        return advicesRepository.save(advices)
    }

    fun update(advices: Advices):Advices{
        try {
            advicesRepository.findById(advices.id)
                ?: throw Exception("ID no existe")

            return advicesRepository.save(advices)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }


    }

    fun updateName(advices: Advices):Advices{
        try {
            val response= advicesRepository.findById(advices.id)
                ?: throw Exception("ID no existe")
            response.apply {
                meeting= advices.meeting
            }
            return advicesRepository.save(response)
        }
        catch (ex:Exception){
            throw  ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }


}