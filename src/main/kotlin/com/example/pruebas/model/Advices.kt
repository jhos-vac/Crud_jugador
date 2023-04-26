package com.example.pruebas.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "advices")
class Advices {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id:Long?=null
    @Column(name = "player_id")
    var playerId:Int?=null
    @Column(name = "date_match")
    var dateMatch:String?=null
    var meeting:String?=null
    @Column(name = "color_card")
    var colorCard:String?=null
}