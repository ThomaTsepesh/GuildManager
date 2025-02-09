package org.example.project.syncLogic

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.client.utils.EmptyContent.contentType
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.example.project.screens.guildWar.logics.GuildWarMap

actual class FirebaseSyncService actual constructor() {
    private val httpClient = HttpClient(CIO) {
        install(io.ktor.client.plugins.contentnegotiation.ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                prettyPrint = true
            })
        }
    }
    private val databaseUrl = "https://guildmanager-53aba.firebaseio.com"
    actual suspend fun syncMap(map: GuildWarMap) {
        try {
            val response: HttpResponse =
                httpClient.put("$databaseUrl/guildWarMap.json") {
                    contentType(ContentType.Application.Json)
                    setBody(map)
                }

        } catch (e: Exception) {
            println()
        }
    }

    actual suspend fun getMap(callback: (GuildWarMap) -> Unit) {
        try {
            val map = httpClient.get("$databaseUrl/guildWarMap.json").body<GuildWarMap>()
            callback(map)
        } catch (e: Exception) {
            println()
            return
        }
    }
}