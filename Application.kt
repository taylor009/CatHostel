package me.taylor

import com.fasterxml.jackson.databind.SerializationFeature
import io.ktor.application.*
import io.ktor.features.ContentNegotiation
import io.ktor.jackson.jackson
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.netty.NettyApplicationEngine

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

const val port = 8080
@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = true) {
    install(ContentNegotiation){
        jackson {
            enable(SerializationFeature.INDENT_OUTPUT)
        }
    }
    routing {
        get {
            context.respondText("Welcome to our Cat Hostel")
            context.respond(mapOf("Welcome" to "our Cats hostel"))
        }
        get("/{name}"){
            val name = context.parameters["name"]
            context.respond(mapOf("Cat name:" to name))
        }
    }
}



