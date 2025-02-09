package org.example.project

actual object Platform {
    actual val isAndroid: Boolean
        get() = true
    actual val isWasm: Boolean
        get() = false
    actual val isDesktop: Boolean
        get() = false
}