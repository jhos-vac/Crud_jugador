package com.example.pruebas.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "player")
class Player {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
        var id:Long?=null
        var fullname:String?=null
        var age:Int?=null
        var nationality:String?=null
        var weight:Double?=null
}