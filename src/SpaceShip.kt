package com.example

import io.ktor.locations.Location

@Location("/spaceship/{captain}")
data class SpaceShip (val captain: String){
    @Location("/details/{level}")
    data class Details(val spaceship: SpaceShip, val level: String)

    @Location("/fuel/{tankno}")
    data class Fuel(val spaceship: SpaceShip,  val tankno: Int)

}