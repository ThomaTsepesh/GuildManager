package org.example.project.syncLogic

import org.example.project.screens.guildWar.logics.GuildWarMap

expect class FirebaseSyncService() {
    suspend fun syncMap(map: GuildWarMap)
    suspend fun getMap(callback: (GuildWarMap) -> Unit)
}