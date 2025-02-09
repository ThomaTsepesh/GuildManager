package org.example.project.syncLogic

import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import org.example.project.screens.guildWar.logics.GuildWarMap

actual class FirebaseSyncService actual constructor(){

    private val database by lazy { Firebase.database }

    actual suspend fun syncMap(map: GuildWarMap) {
        val mapRef = database.getReference("guildWarMap")
        mapRef.setValue(map).addOnFailureListener {
            println("Failed to sync map: ${it.message}")
        }
    }

    actual suspend fun getMap(callback: (GuildWarMap) -> Unit) {
        val mapRef = database.getReference("guildWarMap")
        mapRef.get().addOnSuccessListener {
            val map = it.getValue(GuildWarMap::class.java)
            if (map != null) {
                callback(map)
            }
        }.addOnFailureListener {
            println("Failed to get map: ${it.message}")
        }
    }
}