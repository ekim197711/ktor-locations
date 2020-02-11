package com.example

import com.fasterxml.jackson.databind.SerializationFeature
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.features.DefaultHeaders
import io.ktor.http.ContentType
import io.ktor.jackson.jackson
import io.ktor.locations.Locations
import io.ktor.locations.get
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing

fun main(args: Array<String>): Unit = io.ktor.server.tomcat.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(Locations) {
    }

    install(DefaultHeaders){
        header("Minecraft-Cool-Player", "Mike")
        header("Video_Topic", "DefaultHeader_Ktor_Kotlin")
    }

    install(ContentNegotiation) {
        jackson {
            enable(SerializationFeature.INDENT_OUTPUT)
        }
    }

    routing {
        get("/") {
            call.respondText("HELLO WORLD!", contentType = ContentType.Text.Plain)
        }

        get<SpaceShip> {
            call.respondText ("THis is my spaceship ${it.captain}")
        }
        get<SpaceShip.Details> {
            call.respondText ("Spaceship details ${it.level} ${it.spaceship.captain}")
        }
        get<SpaceShip.Fuel> {
            call.respondText ("Spaceship fueltank ${it.tankno} ${it.spaceship.captain}")
        }



    }
}

