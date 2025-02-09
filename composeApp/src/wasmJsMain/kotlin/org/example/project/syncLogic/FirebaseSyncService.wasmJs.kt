package org.example.project.syncLogic

import org.example.project.screens.guildWar.logics.GuildWarMap

actual class FirebaseSyncService actual constructor() {
    actual suspend fun syncMap(map: GuildWarMap) {
    }

    actual suspend fun getMap(callback: (GuildWarMap) -> Unit) {
    }
}