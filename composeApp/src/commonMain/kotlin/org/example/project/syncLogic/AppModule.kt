package org.example.project.syncLogic

import org.example.project.Platform
import org.koin.dsl.module


val appModule = module {
    single<FirebaseSyncService> {
        getFirebaseSyncServices()
    }
}
fun getFirebaseSyncServices(): FirebaseSyncService{
    return FirebaseSyncService()
}