package org.example.project

actual object Platform {
    actual val isAndroid: Boolean
        get() = false
    actual val isWasm: Boolean
        get() = true
    actual val isDesktop: Boolean
        get() = false
}