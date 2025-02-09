package org.example.project

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.example.project.syncLogic.FirebaseSyncService
import org.example.project.syncLogic.appModule
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin
import org.koin.core.component.get

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "GuildManager",
    ) {
        desktopApp.init()
        App()
    }
}

object desktopApp: KoinComponent {
    fun init(){
        startKoin {
            modules(appModule)
        }
        val firebaseSyncService = get<FirebaseSyncService>()
    }
}