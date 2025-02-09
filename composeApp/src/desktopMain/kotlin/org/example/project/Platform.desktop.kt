package org.example.project

actual object Platform {
    actual val isAndroid: Boolean
        get() = false
    actual val isWasm: Boolean
        get() = false
    actual val isDesktop: Boolean
        get() = true
}